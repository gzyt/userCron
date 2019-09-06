
import { Table } from 'antd';
import React,{Component} from 'react';
import Axios from 'axios';

class Weather extends Component {
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
                title: '城市',
                dataIndex: 'city',
                key: 'city',
              },
              {
                title: '日期',
                dataIndex: 'dateTime',
                key: 'dateTime',
              },
              {
                title: '天气',
                dataIndex: 'cond_txt',
                key: 'cond_txt',
              },
              {
                title: '风向',
                dataIndex: 'wind_dir',
                key: 'wind_dir',
              },
              {
                title: '风力',
                dataIndex: 'wind_sc',
                key: 'wind_sc',
              },
              {
                title: '相对湿度',
                dataIndex: 'hum',
                key: 'hum',
              },  
               {
                title: '大气压强',
                dataIndex: 'pres',
                key: 'pres',
              },  
               {
                title: '最高温度',
                dataIndex: 'tmp_max',
                key: 'tmp_max',
              },  
               {
                title: '最低温度',
                dataIndex: 'tmp_min',
                key: 'tmp_min',
              },  
               {
                title: '日出时间',
                dataIndex: 'sunStartTime',
                key: 'sunStartTime',
              }, 
               {
                title: '日落时间',
                dataIndex: 'sunEndTime',
                key: 'sunEndTime',
              }, 
            ]
        }
    }
//当组件输出到 DOM 后会执行 componentDidMount()
componentDidMount(){
    const _this=this;    //先存一下this，以防使用箭头函数this会指向我们不希望它所指向的对象。
    Axios.post('http://localhost:8080/weather')
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

export default Weather;