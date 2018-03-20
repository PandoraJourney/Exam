import React, { Component } from 'react'
import ProductAdministrationComponent from '../Component/ProductAdministrationComponent'
import '../../node_modules/bootstrap/dist/css/bootstrap.min.css'
import PropTypes from 'prop-types'
import axios from 'axios'

class ProductAdministrationContainer extends Component {
    constructor(props, context) {
        super(props, context)
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleBack = this.handleBack.bind(this);
        this.state = {
            product:
                {
                    title: '',
                    image: '',
                    description: '',
                    quantity: '',
                    price: ''
                }
        }
    }
    handleBack(){
        return(this.context.router.goBack());
    }

    componentWillMount(){
        if(this.props.params.productId !== undefined)
        {
            axios.get('https://itpro2017.herokuapp.com/api/products').then((response) => {
               this.setState({product: response.data[this.props.params.productId-1] })});
        }
    }
    handleSubmit(event) {
        event.preventDefault();
        for (var x in this.state)
            console.log(this.state[x]);
    }
    handleChange(fieldName) {
        return (e) => {
            var product = this.state.product;
            product[fieldName] = e.target.value;
            this.setState({ product: product });
        };
    }

    render() {
        var props = {onBack: this.handleBack, handleChange: this.handleChange, handleSubmit: this.handleSubmit, product: this.state.product };
        console.log(this.state);
        return (
            <div>
                <ProductAdministrationComponent  {...props} />
            </div>
        );
    }     

}
ProductAdministrationContainer.contextTypes = {
    router: PropTypes.object.isRequired,
  };


export default ProductAdministrationContainer;