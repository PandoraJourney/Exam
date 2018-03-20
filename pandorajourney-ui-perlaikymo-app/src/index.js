import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import './index.css';
import ProductListContainer from './Container/ProductListContainer'
import ProductDetailsContainer from './Container/ProductDetailsContainer'
import CartDetailsContainer from './Container/CartDetailsContainer'
import ProductListAdministrationContainer from './Container/ProductListAdministrationContainer'
import ProductAdministrationContainer from './Container/ProductAdministrationContainer'
import { Router, Route, IndexRoute, browserHistory } from 'react-router'
import {injector} from 'react-services-injector';
import services from './Service';

injector.register(services);

var NoMatch = (props) => {
  return <div>Route did not match</div>;
};

class Admin extends Component {
  render() {
    return (<div>{this.props.children}</div>);
  }
}

ReactDOM.render(
  <Router history={browserHistory}>
  <Route path="/" component={App}>
      {/* <IndexRoute component={ProductListContainer} /> */}
      <Route path="/products" component={ProductListContainer} />
      <Route path="/products/:id" component={ProductDetailsContainer} />
      <Route path={"/cart-details"} component={CartDetailsContainer} />
      <Route path="/admin" component={Admin} >
        <IndexRoute component={ProductListAdministrationContainer} />
        <Route path="products/new" component={ProductAdministrationContainer} />
        <Route path="products/:productId" component={ProductAdministrationContainer} />
      </Route>
      <Route path="*" component={NoMatch} />
    </Route>

  </Router>,
  document.getElementById('root')
);

