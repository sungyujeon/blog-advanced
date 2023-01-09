import { createGlobalStyle } from 'styled-components';
import { reset } from './reset';

const GlobalStyle = createGlobalStyle`
  ${reset}
  * {
    text-decoration: none;
    box-sizing: border-box;
  }
  body{
    font-family: 'Spoqa Han Sans Neo', 'sans-serif';
  }
  button {
    all: unset;
    cursor: pointer;
  }
`;

export default GlobalStyle;