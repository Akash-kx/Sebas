export interface YourOrderDataType {

  productSize: string,
  productQuantity: number,
  productImagePath: string,
  productDescription: string
  yourOrderClusterId: {
      emailId: string,
      productId: number
  },
  productName: string,
  productPrice: number
}
