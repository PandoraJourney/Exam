import React, { Component } from 'react';
import CartSummaryComponent from '../Component/CartSummaryComponent'
import PropTypes from 'prop-types'
import axios from 'axios'
import '../../node_modules/bootstrap/dist/css/bootstrap.min.css'
// import picture from './samsung.jpg'
import {injector} from 'react-services-injector'


class CartSummaryContainer extends Component {
  constructor(props, context) {
    super(props, context);
    this.state = { itemCount: 0 };
  }

  componentDidMount() {
    const {EventEmitter} = injector.get();
    EventEmitter.subscribe(this, this.onCartEvent, 'AddToCart');
    EventEmitter.subscribe(this, this.onCartEvent, 'RemoveFromCart');
    this.getAndUpdateCartItems();
  }

  componentWillUnmount(){
    const {EventEmitter} = injector.get();
    EventEmitter.unsubscribe(this);
  }

  onCartEvent=()=>{
    this.setState({itemCount:7});
    // this.getAndUpdateCartItems();
  }

  getAndUpdateCartItems=()=>{
    // if (UserService.getUsername()) {
    //   axios.get('/api/users/' + UserService.getUsername() + '/cart-products').then(function (response) {
    //     self.setState({
    //       itemCount: response.data.length
    //     });
    //   });
    axios.get('https://itpro2017.herokuapp.com/api/products').then((response) =>{
          this.setState({itemCount: response.data.length});
        });
    }


  render() {
    return (
      <div>
        <CartSummaryComponent itemCount={this.state.itemCount}/>
          </div>
    )
  }
}

CartSummaryContainer.contextTypes = {
  router: PropTypes.object.isRequired,
};

export default injector.connect(CartSummaryContainer);