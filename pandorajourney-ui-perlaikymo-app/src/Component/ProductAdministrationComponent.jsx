import React, {Component} from 'react';
import '../../node_modules/bootstrap/dist/css/bootstrap.min.css';

class ProductAdministrationComponent extends Component{     
    render(){ 
        return(
            <div>
             <div className="container">
             <div className="row">
                 <div className="col-sm-6 col-md-4">
                    <form onSubmit={this.props.handleSubmit}>
                        <div className="form-group">
                            <label>Title</label>
                            <input type="text" name="title" className="form-control" placeholder={this.props.title} onChange={this.props.handleChange('title')} value={this.props.product.title}/>
                        </div>
                        <div className="form-group">
                            <label>Image URL</label>
                            <input type="text" name="image" className="form-control" placeholder={this.props.image} onChange={this.props.handleChange('image')} value={this.props.product.image}/>
                        </div>
                        <div className="form-group">
                            <label>Description</label>
                            <textarea name="description" className="form-control" rows="3" placeholder={this.props.description} onChange={this.props.handleChange('description')} value={this.props.product.description}></textarea>
                        </div>
                        <div className="form-group">
                            <label>Quantity</label>
                            <input type="number" name="quantity" className="form-control" placeholder={this.props.quantity} min={0} step="any" onChange={this.props.handleChange('quantity')} value={this.props.product.quantity}/>
                        </div>
                        <div className="form-group">
                            <label>Price</label>
                            <input type="number" name="price" className="form-control" placeholder={this.props.price} min={0} onChange={this.props.handleChange('price')} value={this.props.product.price}/>
                        </div> 
                        <button type="submit" className="btn btn-default">Save</button>
                        <button style={{ marginRight: '10px' }} className="btn btn-default" onClick={this.props.onBack}>Cancel</button>
                    </form>
                 </div>
             </div>
         </div>
        </div>
    );
}    

}

export default ProductAdministrationComponent;