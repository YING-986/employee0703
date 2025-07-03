import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import EmployeeList from './page/EmployeeList.tsx'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Detail from './page/Detail.tsx'
import App from './App.tsx'
import ApiResponse from './ApiResponse.tsx'

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    {/* <App /> */}
    {/* <ApiResponse/> */}

    <BrowserRouter>
      <Routes>
        <Route path="/" element={<EmployeeList />} />
        <Route path="/employee/:id" element={<Detail />} />
      </Routes>
    </BrowserRouter>

  </StrictMode>
)
