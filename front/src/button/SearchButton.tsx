
// export default function SearchButton() {}
import React from 'react';

interface SearchBarProps {
  searchId: string;
  onSearchIdChange: (value: string) => void;
  onSearch: () => void;
}

const SearchButton: React.FC<SearchBarProps> = ({
  searchId,
  onSearchIdChange,
  onSearch,
}) => {
    
  return (
    <div style={{ display: 'flex', gap: '10px' }}>
      <input
        type="text"
        placeholder="検索条件を入力してください"
        value={searchId}
        onChange={(e) => onSearchIdChange(e.target.value)}
      />
      <button onClick={onSearch}>検索</button>
    </div>
  );
};

export default SearchButton;