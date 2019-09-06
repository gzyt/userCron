import  React,{Component} from 'react';

import UserInfo from './page/UserInfo';
import TransLation from './page/TransLation';
import HeadLine from './page/HeadLine';
import Login from './page/login';
import Weather from './page/Weather';
import {HashRouter,Switch,Route,Link} from 'react-router-dom';
import { Layout, Menu, Icon } from 'antd';

const { Header, Content,  Sider } = Layout;
class App extends Component{
  state = {
    collapsed: false,
  };
  toggle =()=> {
    this.setState({
      collapsed: !this.state.collapsed,
    });
  };
  render(){
    return <HashRouter>
      <Switch>
            <Route exact path="/"  component={Login}></Route>
            <Layout>
              <Sider trigger={null} collapsible collapsed={this.state.collapsed}>
                  <div className="title">
                      <p>后台管理</p>
                  </div>
                  <Menu theme="dark">
                    <Menu.Item><Link to="/Weather">天气预报接口</Link></Menu.Item>
                    <Menu.Item><Link to="/HeadLine">头条新闻接口</Link></Menu.Item>
                    <Menu.Item><Link to="/TransLation">Translation双向翻译</Link></Menu.Item>
                    <Menu.Item> <Link to="/UserInfo">Webservice+cxf接口</Link></Menu.Item>
                </Menu>
              </Sider>
              <Layout>
                <Header className="header" style={{background: '#fff'}}>
                  <Icon className="trigger" type={this.state.collapsed ? 'menu-unfold' : 'menu-fold'} onClick={this.toggle} />
                  </Header>
                  <Content  style={{ margin: '24px 16px',padding: 24,background: '#fff',minHeight: 700}}>
                      <Route path="/Weather"  component={Weather}></Route>
                      <Route path="/HeadLine"  component={HeadLine}></Route>
                      <Route path="/TransLation"  component={TransLation}></Route>
                      <Route path="/UserInfo"  component={UserInfo}></Route>
                    
                  </Content>
              </Layout>
            </Layout>
            </Switch>
        </HashRouter>
    }
}
export default App;