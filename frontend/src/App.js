import { BrowserRouter, Route, Routes } from "react-router-dom";

import { Home } from './pages';
import { Header } from './components';

import GlobalStyle from "./styles/GlobalStyle";

function App() {
  return (
    <>
      <GlobalStyle />
      <BrowserRouter>
        <Header />
        <Routes>
          <Route path="/" element={<Home />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
