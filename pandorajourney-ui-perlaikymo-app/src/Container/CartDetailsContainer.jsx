import React, { Component } from 'react'
import axios from 'axios'
import CartDetailsComponent from '../Component/CartDetailsComponent'
import {injector} from 'react-services-injector'

class CartDetailsContainer extends Component {

  constructor() {
    super();
    this.state = { items: [] };
  }

  componentWillMount() {
    // const {UserService} = injector.get();
    //axios.get('/api/users/' + UserService.getUsername() + '/cart-products').then((response) => {
    axios.get('https://itpro2017.herokuapp.com/api/products').then((response) => {
      return this.setState({ items: response.data });
      //console.log(response);
    }).catch(function (error) {
      console.log(error);
    });
  }

  handleItemRemove=(item)=> {
    const {EventEmitter} = injector.get();
      // const {UserService} = injector.get();
      // axios.delete('/api/users/' + UserService.getUsername() + '/cart-products/' + item.id).then((response) => {
    //   axios.post('/api/users/cart-details/'+ item.id).then((response) => {  
    //    this.setState({ items: response.data });
    //     EventEmitter.publish({ eventType: 'RemoveFromCart' });
    //   });
    // };
    EventEmitter.publish({ eventType: 'RemoveFromCart' });  
  }

  render() {
    return <CartDetailsComponent items={this.state.items} onItemRemove={this.handleItemRemove} />;
  }
}

// export default injector.connect(CartDetailsContainer);
export default injector.connect(CartDetailsContainer);
