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
    this.state = { providers: [],
                    service:"" };
  }

  componentWillMount() {
    var index = this.props.params.id;
    axios.get('https:/localhost:8080/providers/service/'+index).then((response) => {
      this.setState({ providers: response.data });
    });
    axios.get('https:/localhost:8080/service/'+index).then((response) => {
      this.setState({ service: response.data });});
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
      <ProductDetailsComponent service={this.state.service} providers={this.state.providers} onAddToCart={this.handleAddToCart} onBack={this.handleBack} />
    );
  }
};

ProductDetailsContainer.contextTypes = {
  router: PropTypes.object.isRequired,
};


export default injector.connect(ProductDetailsContainer);