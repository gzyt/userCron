import './css/index.css';
import './css/main.less';
import './css/login.css';
import React from 'react';
import ReactDOM from 'react-dom';
import App from './component/app';
// import WrappedNormalLoginForm from './component/page/login';
import 'antd/dist/antd.css';

ReactDOM.render(
    <App />,
    document.getElementById('app')
);