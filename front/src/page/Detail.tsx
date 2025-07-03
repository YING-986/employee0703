import { useParams } from "react-router-dom";

export default function Detail() {
  const { id } = useParams<{ id: string }>();

  return (
    <div style={{ padding: 20 }}>
      <h2>社員情報詳細</h2>
      <p>選択された社員 ID: <strong>{id}</strong></p>
      <p>ID、氏名、生年月日、入社年月日、郵便番号、住所、TEL、メールアドレス、所属部署、異動
      </p>
    </div>
  );
}
