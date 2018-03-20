import React, { Component } from 'react'
import './App.css'
import {Link} from 'react-router'
import CartSummaryContainer from './Container/CartSummaryContainer'
import UserNameComponent from './Component/UserNameComponent';
import {injector} from 'react-services-injector';

class App extends Component {
  
  render() {
   const {UserService} = injector.get();
    return (
      <div className="container">
        <div className="row">
          <div className="col-sm-10 col-md-12">
            <nav className="navbar navbar-inverse">
              <div className="container-fluid">
                <div className="navbar-header">
                  <Link className="navbar-brand" to="/products" activeClassName="active">Home</Link>
                </div>
                <ul className="nav navbar-nav">
                  <li><Link to="/admin" activeClassName="active">Admin</Link></li>
                </ul>
                {/* <form className="navbar-form navbar-left" action="/action_page.php"> */}
                <ul className="nav navbar-nav">
                  <li><UserNameComponent /></li>
                </ul>
                  
                {/* </form> */}
                <ul className="nav navbar-nav navbar-right">
                  <li><Link to="/cart-details">{UserService.user} <CartSummaryContainer/></Link></li>
                </ul>
               </div>
            </nav>
          </div>
        </div>
        {this.props.children}
      </div>
    );
  }
}
export default injector.connect(App,{toRender: ['UserService']});