/*import React from 'react';
import ReactDOM from 'react-dom';
import Sing from './Sing'
import registerServiceWorker from './registerServiceWorker';

ReactDOM.render(<Sing/>, document.getElementById('root'));
registerServiceWorker();*/

import React from 'react';
import ReactDOM from 'react-dom';
import MyTable from './components/tableComponent/MyTable'

import registerServiceWorker from './registerServiceWorker';

const tabColumn = {
    title : "用户信息详细列表",
    uuid : "编号",
    account : "用户账号",
    password : "密码",
    createTime : "创建时间",
    url : "http://localhost:8080/getAdminList"
}
ReactDOM.render(<MyTable {...tabColumn} />, document.getElementById('root'));
registerServiceWorker();
