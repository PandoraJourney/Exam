import React, { Component } from 'react'
import ProductDetailsComponent from '../Component/ProductDetailsComponent'
import '../../node_modules/bootstrap/dist/css/bootstrap.min.css'
import {injector} from 'react-services-injector'
import axios from 'axios'
import PropTypes from 'prop-types'

class ProductDetailsContainer extends Component {
  constructor(context, props) {
    super(context, props)
    this.handleAddToCart = this.handleAddToCart.bind(this);
    this.handleBack = this.handleBack.bind(this);
    this.state = { product: "" };
  }

  componentWillMount() {
    var index = this.props.params.id - 1;
    axios.get('https://itpro2017.herokuapp.com/api/products').then((response) => {
      this.setState({ product: response.data[index] });
    });
  }


   handleAddToCart(){
    var body = {
      id: this.state.product.id,
      image: this.state.product.image,
      title: this.state.product.title
    };
    const {EventEmitter} = injector.get();
   EventEmitter.publish({ eventType: 'AddToCart' });
    // axios.post('/api/users/' + UserService.user() + '/cart-products', body).then(function() {
      // EventEmitter.publish({ eventType: 'AddToCart' });
    // });
  }

  handleBack() {
    return (this.context.router.goBack());
  }

  render() {
    return (
      <ProductDetailsComponent product={this.state.product} onAddToCart={this.handleAddToCart} onBack={this.handleBack} />
    );
  }
};

ProductDetailsContainer.contextTypes = {
  router: PropTypes.object.isRequired,
};


export default injector.connect(ProductDetailsContainer);