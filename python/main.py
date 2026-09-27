class Product:
    def __init__(self, pro_id: str, name: str, rating: float, review: str, price: float, stock: int):
        self.pro_id = pro_id
        self.name = name
        self.rating = rating
        self.review = review
        self.price = price
        self.stock = stock

    def add_to_cart(self):
        print(f"Product '{self.name}' added to cart.")

    def buy(self):
        if self.stock > 0:
            self.stock -= 1
            print(f"Purchased {self.name}. Remaining stock: {self.stock}")
        else:
            print(f"Product {self.name} is out of stock!")


class Categories:
    def __init__(self, cat_id: str, name: str):
        self.cat_id = cat_id
        self.name = name
        self.pro_list = []

    def add_product(self, product: Product):
        self.pro_list.append(product)

    def search_by_cat(self):
        print(f"\n--- Category: {self.name} ---")
        for p in self.pro_list:
            print(f"- {p.name} | Price: ${p.price} | Stock: {p.stock}")

    def sort_products(self):
        self.pro_list.sort(key=lambda p: p.price)
        print(f"Products sorted by price in {self.name} category.")


class Cart:
    def __init__(self, cart_id: str):
        self.cart_id = cart_id
        self.item_list = []
        self.total_amount = 0.0

    def add_product(self, product: Product):
        self.item_list.append(product)
        self.total_amount += product.price
        print(f"Added to Cart: {product.name}")

    def pay_now(self):
        print(f"Proceeding to payment... Total Cart Amount: ${self.total_amount:.2f}")


class Order:
    def __init__(self, order_id: str, total: float, date: str, details: str):
        self.order_id = order_id
        self.total = total
        self.date = date
        self.details = details
        self.order_status = "Pending"

    def place_order(self):
        self.order_status = "Placed"
        print(f"Order {self.order_id} placed successfully on {self.date} for Total: ${self.total:.2f}")


class Payment:
    def __init__(self, pay_id: str, pay_method: str, pay_amount: float):
        self.pay_id = pay_id
        self.pay_method = pay_method
        self.pay_amount = pay_amount
        self.pay_status = "Initiated"

    def complete_payment(self):
        self.pay_status = "Completed"
        print(f"Payment of ${self.pay_amount:.2f} via {self.pay_method} successful!")

    def check_status(self):
        print(f"Payment ID {self.pay_id} Status: {self.pay_status}")


class Shipment:
    def __init__(self, ship_id: str, tracking_no: str, date: str, ship_date: str):
        self.ship_id = ship_id
        self.tracking_no = tracking_no
        self.date = date
        self.ship_date = ship_date
        self.deli_status = "In Transit"

    def check_status(self):
        print(f"Shipment Tracking No: {self.tracking_no} | Status: {self.deli_status} | Shipped On: {self.ship_date}")


if __name__ == "__main__":
    print("==========================================")
    print("   ONLINE SHOPPING SYSTEM (PYTHON DEMO)  ")
    print("==========================================")

    laptop = Product("P101", "Gaming Laptop", 4.8, "Excellent performance", 1200.00, 5)
    mouse = Product("P102", "Wireless Mouse", 4.2, "Smooth and reliable", 25.50, 15)

    electronics = Categories("C01", "Electronics")
    electronics.add_product(laptop)
    electronics.add_product(mouse)

    electronics.search_by_cat()
    electronics.sort_products()

    print("\n--- Shopping Cart Operations ---")
    cart = Cart("CART_001")
    cart.add_product(laptop)
    cart.add_product(mouse)
    cart.pay_now()

    print("\n--- Order Management ---")
    order = Order("ORD_9988", cart.total_amount, "2026-09-27", "2 Items: Laptop, Mouse")
    order.place_order()

    print("\n--- Payment Processing ---")
    payment = Payment("PAY_7711", "Credit Card", cart.total_amount)
    payment.complete_payment()
    payment.check_status()

    print("\n--- Shipment Tracking ---")
    shipment = Shipment("SHIP_3321", "TRK_99182736", "2026-09-27", "2026-09-28")
    shipment.check_status()

    print("\n==========================================")