
import  React,{Component} from 'react';
import { Input,Mentions } from 'antd';
import Axios from 'axios';
const { Search} = Input;

class TransLation extends Component{
    constructor(props){
        super(props);
        this.state={
            value: null,
            word: "单词翻译结果"
        };
        this.getWord = this.getWord.bind(this);//手动绑定
         this.handleChange = this.handleChange.bind(this);
    }
    getWord(){
        const inpVal = this.state.value;
        console.log(inpVal)
        const _this=this;    //先存一下this，以防使用箭头函数this会指向我们不希望它所指向的对象。
        var data ={word:inpVal} ;
        Axios({
            method: 'post',
            url: 'http://localhost:8080/TransLation',
            params: data
        }).then(function (response) {
            console.log(response.data)
            _this.setState({
                word:response.data
            });
            })
            .catch(function (error) {
            console.log(error);
            _this.setState({
                word:'查询失败'
            })
            });
    }
    handleChange(event) {
        const _this=this;    //先存一下this，以防使用箭头函数this会指向我们不希望它所指向的对象。
        this.setState({value: event.target.value});
  }
    render(){
        return <div>
        <Search
            placeholder="input search words"
            enterButton="Search"
            size="large"
            value={this.state.value}
            onChange={this.handleChange}
            onSearch={this.getWord.bind(this)}
        />
        <Mentions style={{ width: '100%',height:'500px',top:'30px' }}  value={this.state.word} readOnly>
      </Mentions>
        </div>
    }
   
}
export default TransLation;