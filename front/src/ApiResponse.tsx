import { useEffect, useState } from 'react'

import './App.css'

interface Student {
  id: number;
  name: string;
  age: number;
  email: string;
}

function ApiStudent() {
  const [students, setStudents] = useState<Student[]>([]);
  const [newStudent, setNewStudent] = useState<Omit<Student, 'id'>>({ name: '', age: 0, email: '' });

  const fetchStudents = () => {
    fetch('http://localhost:8080/api/students')
      .then(res => res.json())
      .then(setStudents);
  };

  useEffect(() => {
    fetchStudents();
  }, []);

  const handleAdd = () => {
    fetch('http://localhost:8080/api/students', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(newStudent),
    }).then(() => {
      setNewStudent({ name: '', age: 0, email: '' });
      fetchStudents();
    });
  };

  return (
    <div style={{ padding: '2rem' }}>
      <h1>学生管理系统</h1>

      <h2>添加学生</h2>
      <input placeholder="姓名" value={newStudent.name} onChange={e => setNewStudent({ ...newStudent, name: e.target.value })} />
      <input type="number" placeholder="年龄" value={newStudent.age} onChange={e => setNewStudent({ ...newStudent, age: parseInt(e.target.value) })} />
      <input placeholder="邮箱" value={newStudent.email} onChange={e => setNewStudent({ ...newStudent, email: e.target.value })} />
      <button onClick={handleAdd}>添加</button>

      <h2>学生列表</h2>
      <ul>
        {students.map(s => (
          <li key={s.id}>{s.name} - {s.age}岁 - {s.email}</li>
        ))}
      </ul>
    </div>
  );
}

export default ApiStudent
