import React, { Component } from 'react'
import PropTypes from 'prop-types'
import image from './samsung.jpg'

class CartDetailsComponent extends Component {
    render() {
        if (this.props.items.length !== 0 || this.props.items.length!==null)
            var itemsHtml = this.props.items.map((item, index) => {
                return (
                    <tr >
                        {/* <td><img className="media-object" src={image} style={{ width: '50px' }} /></td> */}
                        <td>{item.title}</td>
                        <td><button className="btn btn-danger" onClick={this.props.onItemRemove} >Remove from cart</button></td>
                    </tr>
                );
            });
        else {
            return (
                <div>
                    test
            </div>);
        }
        return (
            <div>
                <table className="table">
                    <tbody>
                        {itemsHtml}
                    </tbody>
                </table>
            </div>);
    }
}
CartDetailsComponent.propTypes = {
    items: PropTypes.array.isRequired,
    onItemRemove: PropTypes.func.isRequired
};


export default CartDetailsComponent;