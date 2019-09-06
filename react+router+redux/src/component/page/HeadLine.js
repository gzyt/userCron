import { Table } from 'antd';
import React,{Component} from 'react';
import Axios from 'axios';


class HeadLine extends Component {
    constructor(props){
        super(props);
        this.state = {
         ModalText: 'Content of the modal',
         visible: false,
         visibleEdit:false,
         confirmLoading: false,
            dataSource: [],
            columns :[
              {
                title: '文章作者',
                dataIndex: 'author_name',
                key: 'author_name',
              },
              {
                title: '类别',
                dataIndex: 'category',
                key: 'category',
              },
              {
                title: '时间',
                dataIndex: 'date',
                key: 'date',
              },
              {
                title: '标题',
                dataIndex: 'title',
                key: 'title',
              },
              {
                title: 'url',
                dataIndex: 'url',
                key: 'url',
              },    
            ]
        }
    }
//当组件输出到 DOM 后会执行 componentDidMount()
componentDidMount(){
    const _this=this;    //先存一下this，以防使用箭头函数this会指向我们不希望它所指向的对象。
    Axios.post('http://localhost:8080/HeadLine')
    .then(function (response) {
      console.log(response.data)
      _this.setState({
        dataSource:response.data,
        isLoaded:true
      });
    })
    .catch(function (error) {
      console.log(error);
      _this.setState({
        isLoaded:false,
        error:error
      })
    })
  }
    render(){     
      return (
        <div> 
            <Table dataSource={this.state.dataSource}  columns={this.state.columns} size="middle" />
        </div>
        
    )
    }
}

export default HeadLine;