import './EmployeeList.css'
import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';

// 数据结构（类型）
interface Employee {
  selected: boolean; // 是否勾选（用于复选框）
  id: string;
  name: string;
  department: string;
  email: string;
  phone: string;
}

// 每页显示的5员工
const pageSize = 5;
// 初始数据

// 主组件：社員情報一覧（EmployeeList）
export default function EmployeeList() {
  const [employees, setEmployees] = useState<Employee[]>([]); // 使用 useState 保存员工列表数据
  const [searchId, setSearchId] = useState<string>("");// 搜索输入框的内容
  const [currentPage, setPage] = useState(1); // 当前页码（默认第1页）
  const [editingId, setEditingId] = useState<string | null>(null); // 当前处于编辑状态的员工 ID
  const [filtered, setFiltered] = useState<Employee[] | null>(null);// 新增状态：保存过滤后的数据（用于搜索）

  // 路由导航函数（用于跳转详情页）
  const navigate = useNavigate();

  // 初回データ取得
  useEffect(() => {
    fetchAllEmployees();
  }, []);

  const fetchAllEmployees = async () => {
    try {
      const res = await fetch('http://localhost:8080/api/employee-list/searchAll');
      const data = await res.json();
      setEmployees(data);
    } catch (error) {
      console.error('社員データの取得に失敗しました', error);
    }
  };

  // 検索ボタン
  const handleSearch = () => {
    const keyword = searchId.trim().toLowerCase(); // 去除首尾空格并统一小写
    if (!keyword) {
      alert("検索キーワードを入力してください。");
      return;
    }
    // ID/姓名关键词，进行模糊搜索
    const results = employees.filter(emp =>
      emp.id.toLowerCase().includes(keyword) ||
      emp.name.toLowerCase().includes(keyword)
    );
    if (results.length === 0) {
      alert("一致する社員が見つかりませんでした。");
    } else {
      setFiltered(results); // 用筛选后的数据替代显示
      setPage(1); // 重置页码为第一页
    }
  };
  
  // 重置搜索
  const handleReset = () => {
    setSearchId("");
    setFiltered(null);
    setPage(1);
  };

  // 変更ボタン
  const handleUpdate = () => {
    alert("変更されました");
    // TODO: 可添加修改逻辑
  };

  // 行追加ボタン
  const handleAdd = () => {
    const newId = `NEW${Date.now()}`;// TOFIX：临时ID `NEW${Date.now()}`
    const newEmp: Employee = {
      selected: false, id: newId, name: '', department: '', email: '', phone: '',
    };
    // 将新员工添加到列表末尾
    setEmployees(prev => {
      const startIdx = (currentPage - 1) * pageSize;
      const endIdx = currentPage * pageSize;
      const pageEmployees = prev.slice(startIdx, endIdx);
      const isPageFull = pageEmployees.length >= pageSize;
      // 插入新员工到当前页尾部对应位置
      if (isPageFull) {
        // 挤出最后一个员工，把新员工插入最后
        const newPage = [...pageEmployees.slice(0, pageSize - 1), newEmp];
        const remaining = [...prev.slice(0, startIdx), ...newPage, ...prev.slice(endIdx - 1)];
        return remaining;
      } else {
        // 当前页未满，正常追加到当前页末尾
        const before = prev.slice(0, endIdx);
        const after = prev.slice(endIdx);
        return [...before, newEmp, ...after];
      }
    });
    setEditingId(newId); // 新增后自动进入编辑状态
  };

  // 削除ボタン：删除被选中的员工
  const handleDelete = async () => {
    const selectedIds = employees.filter(emp => emp.selected).map(emp => emp.id);
    if (selectedIds.length === 0) {
      alert("削除する社員を選択してください。");
      return;
    }

    const confirm = window.confirm(`本当に${selectedIds.length}件削除しますか？`);
    if (!confirm) return;

    try {
      // 调用后端删除接口
      const res = await fetch('http://localhost:8080/api/employee-list/delete', {
        method: 'DELETE',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(selectedIds),
      });
      if (!res.ok) throw new Error('削除失敗');

      // 删除成功后，从前端状态移除
      setEmployees(prev => prev.filter(emp => !selectedIds.includes(emp.id)));
      alert('削除しました');
    } catch (error) {
      console.error('削除エラー:', error);
      alert('削除に失敗しました');
    }
  };

  // 保存ボタン
  const handleSave = async () => {
    const invalid = employees.some(emp => !emp.name || !emp.id);// 校验逻辑
      if (invalid) {
        alert("名前とIDは必須です。");
        return;
      }
    const newEmployees = employees.filter(emp => emp.id.startsWith("NEW"));

    try {
      // 插入新增员工
      for (const emp of newEmployees) {
        await fetch("http://localhost:8080/api/employee-list/insert", {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify({
            id: emp.id,
            name: emp.name,
            department: emp.department,
            email: emp.email,
            phone: emp.phone
          }),
        });
      }

      alert("保存しました");
      setEditingId(null);

      // 重新加载员工列表
      const res = await fetch("http://localhost:8080/api/employee-list/searchAll");
      const data = await res.json();
      setEmployees(data);
      setFiltered(null);
      setPage(1);

    } catch (err) {
      console.error("保存失敗：", err);
      alert("保存に失敗しました");
    }
  };
  

  // 编辑时更新字段值（例如：name、department 等）
  const updateField = (id: string, key: keyof Employee, value: string) => {
    setEmployees(prev =>
      prev.map(emp =>
        emp.id === id ? { ...emp, [key]: value } : emp
      )
    );
  };

  // 根据是否过滤决定使用哪个数据源
  const dataToPaginate = filtered ?? employees;
  // 计算总页数
  const totalPages = Math.ceil(dataToPaginate.length / pageSize);
  // 获取当前页的数据
  const paginatedEmployees = dataToPaginate.slice(
    (currentPage - 1) * pageSize,
    currentPage * pageSize
  );
  // 上一页
  const goPrev = () => {
    if (currentPage > 1) setPage(currentPage - 1);
  };
  // 下一页
  const goNext = () => {
    if (currentPage < totalPages) setPage(currentPage + 1);
  };
  // const goToPage = () => {　};

    // 当前页是否已全部选中
  const isCurrentPageAllSelected = paginatedEmployees.length > 0 && paginatedEmployees.every(emp => emp.selected);
  // 切换复选框状态（根据 id 切换某一行是否被选中）
  const toggleCheckbox = (id: string) => {
    setEmployees(prev =>
      prev.map(emp =>
        emp.id === id ? { ...emp, selected: !emp.selected } : emp
      )
    );
  };



  // 全选 / 取消全选（当前页）　　　!!!!过滤模式，勾选Checkbox。
  const toggleCurrentPageSelection = () => {
    const isAllSelected = paginatedEmployees.every(emp => emp.selected);
    const toggleSelected = (list: Employee[]) =>
      list.map(emp => {
        const isOnCurrentPage = paginatedEmployees.some(p => p.id === emp.id);
        return isOnCurrentPage ? { ...emp, selected: !isAllSelected } : emp;
      });

    if (filtered) {
      setFiltered(prev => prev ? toggleSelected(prev) : prev);
    } else {
      setEmployees(toggleSelected);
    }
  };

  // 点击 ID 或名字跳转【社員情報詳細】（编辑中不能跳转）
  const handleNavigate = (id: string, isEditing: boolean) => {
    if (isEditing) {
      alert("編集中のため、詳細ページには遷移できません。");
      return;
    }
    navigate(`/employee/${id}`);
  };

  // 渲染一个可编辑的单元格（只限于 string 类型字段）
  const renderEditableCell = (
    emp: Employee, field: keyof Employee, isEditing: boolean
  ) => {
    if (field === 'selected') return null; // 勾选框不需要通过这个函数渲染
    const value = emp[field];
    // 如果是编辑状态，渲染为输入框，否则渲染值（或“空”）
    return isEditing
      ? <input
          value={typeof value === "string" ? value : ""}
          onChange={e => updateField(emp.id, field, e.target.value)}
        />
      : (value || '（空）');
  };

  return (
    <div className="container">
      {/* 标题 */}
      <h2 style={{ marginBottom: "20px" }}>社員情報一覧</h2>

      <div className="controls" style={{ display: "flex", justifyContent: "flex-end", gap: "10px", marginBottom: "10px" }}>
        <input
          type="text"
          placeholder="検索条件を入力してください"
          value={searchId}
          onChange={(e) => setSearchId(e.target.value)}
        />
        <button onClick={handleSearch}>検索</button>
        <button onClick={handleReset}>リセット</button>
        <button onClick={handleUpdate}>変更</button>
      </div>

      <table className="employee-table">
        <thead>
          <tr>
            {/* 表题 */}
            <th>
              <div style={{ marginBottom: "10px", textAlign: "right" }}>
                <input 
                  type="checkbox" 
                  checked={isCurrentPageAllSelected} 
                  onChange={toggleCurrentPageSelection}
                />
              </div>
            </th>
            <th>ID</th>
            <th>名前</th>
            <th>部門</th>
            <th>メール</th>
            <th>電話</th>
          </tr>
        </thead>
        <tbody>
          {/* 遍历每一位社員，渲染数据行 */}
          {paginatedEmployees.map(emp => {
            const isEditing = editingId === emp.id;
            return (
              <tr key={emp.id}>
                {/* 复选框 */}
                <td>
                  <input
                    type="checkbox"
                    checked={emp.selected}
                    onChange={() => toggleCheckbox(emp.id)}
                  />
                </td>
                {/* ID：点击跳转 */}
                <td className="clickable-id" onClick={() => handleNavigate(emp.id, isEditing)} title="社員情報詳細画面へ">
                  {emp.id}
                </td>
                {/* 姓名：点击跳转 */}
                <td>
                  {isEditing ? <input value={emp.name} onChange={e => updateField(emp.id, "name", e.target.value)} /> : (
                    <span className="clickable-id" onClick={() => handleNavigate(emp.id, isEditing)} title="社員情報詳細画面へ">
                      {emp.name || '（空）'}
                    </span>
                  )}
                </td>
                {/* 部门 */}
                <td>{renderEditableCell(emp, "department", isEditing)}</td>
                {/* 邮箱 */}
                <td>{renderEditableCell(emp, "email", isEditing)}</td>
                {/* 电话 */}
                <td>{renderEditableCell(emp, "phone", isEditing)}</td>
              </tr>
            );
          })}
          
          {/* 搜索结果为空时可隐藏【＋ New】行 */}
          {paginatedEmployees.length > 0 && (
            // 表格下方新增一行：+ New
            <tr onClick={handleAdd} className="add-new-row">
              <td colSpan={6} style={{ textAlign: "left", cursor: "pointer", color: "blue", paddingLeft: "10px" }}>
                ＋ New
              </td>
            </tr>
          )}

        </tbody>
      </table>

      {/* 分页 */}
      <div style={{ marginTop: 15, textAlign: "center" }} className="pagination">
        <button onClick={() => setPage(1)} disabled={currentPage === 1}>⏮</button>
        <button onClick={goPrev} disabled={currentPage === 1}>&lt;&lt;</button>
        <span style={{ margin: "0 15px" }}>
          現在のページ: <strong>{currentPage}</strong>  /  {totalPages} 
        </span>
        <button onClick={goNext} disabled={currentPage === totalPages}>&gt;&gt;</button>
        <button onClick={() => setPage(totalPages)} disabled={currentPage === totalPages}>⏭</button>
      </div>

      <div style={{ marginTop: 10, marginBottom: 20, textAlign: "center" }}>
        <button onClick={handleSave}>保存</button>
        <button onClick={handleDelete}>削除</button>
        
      </div>
    </div>
  );
};
