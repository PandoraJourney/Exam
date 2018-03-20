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
      <Route path="/services" component={ProductListContainer} />
      <Route path="/services/:id" component={ProductDetailsContainer} />
      <Route path={"/service-history"} component={CartDetailsContainer} />
      <Route path="/admin" component={Admin} >
        <IndexRoute component={ProductListAdministrationContainer} />
        <Route path="services/new" component={ProductAdministrationContainer} />
        <Route path="services/:serviceId" component={ProductAdministrationContainer} />
        <Route path="providers/new" component={ProductAdministrationContainer} />
        <Route path="providers/:providerId" component={ProductAdministrationContainer} />
      </Route>
      <Route path="*" component={NoMatch} />
    </Route>

  </Router>,
  document.getElementById('root')
);

