/**
 * Created by Dong on 2018/4/25.
 */
import React,{Component} from 'react'
import $ from 'jquery'
import './MyTable.css'

class MyTable extends Component{
    constructor(){
        super()
        this.state={
            tabData:[{"uuid":"0101011","account":"xwd","password":"xwd233513","createTime":"2018-4-6"},
                {"uuid":"0101012","account":"fag","password":"fag233513","createTime":"2018-4-16"},
                {"uuid":"0101013","account":"lwy","password":"lwy233513","createTime":"2018-4-26"}]
        }
    }

    componentDidMount(){
        this.serverRequest = $.get(this.props.url,function(result){
            console.log(result)
        })
    }

    render(){
        return(
            <div>
                <table border="1" className="myTable">
                    <caption className="myTable-caption">{this.props.title}</caption>
                    <thead>
                    <tr>
                        <th>{this.props.uuid}</th>
                        <th>{this.props.account}</th>
                        <th>{this.props.password}</th>
                        <th>{this.props.createTime}</th>
                    </tr>
                    </thead>
                    <tbody>
                    {this.state.tabData.map(
                        item=><tr key={item.uuid}>
                            <td>{item.uuid}</td>
                            <td>{item.account}</td>
                            <td>{item.password}</td>
                            <td>{item.createTime}</td>
                            </tr>)
                    }
                    </tbody>
                </table>
            </div>
        )
    }
}

export default MyTable