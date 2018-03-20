import React, {Component} from 'react'
import {injector} from 'react-services-injector'
// import axios from 'axios';

class UserNameComponent extends Component {
   constructor() {
       super();
       this.state =  { username: "" };
      }    

      handleUsernameChange=(e)=> {
        let username  = e.target.value;
        this.setState({ username: username });
      }  
      
      handleSubmit=(e)=>{
            e.preventDefault();
            console.log(this.state.username);
            const {UserService} = injector.get();
            UserService.setUser(this.state.username);
            // this.setState( {name :UserService.user});
            // axios.post('http://localhost:8081/api/users/' + this.state.name, this.state.name)
            // .then(response => {
                
            // })  
            // .catch(error => {
            //     console.log(error);
            // })
          console.log(UserService.user);
      }

    render() {
        return (
            <div className="form-group">
            <form onSubmit={this.handleSubmit}>            
                    <input type="text" value={this.state.username} placeholder="Username"  onChange={this.handleUsernameChange} />
                <input type="submit" value="Login" />
            </form>
            </div>
        );
    }

} 


export default injector.connect(UserNameComponent);