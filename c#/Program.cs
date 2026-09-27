using System;
using System.Collections.Generic;
using System.Linq;

namespace OnlineShoppingSystem
{
    public class Product
    {
        public string ProId { get; set; }
        public string Name { get; set; }
        public float Rating { get; set; }
        public string Review { get; set; }
        public double Price { get; set; }
        public int Stock { get; set; }

        public Product(string proId, string name, float rating, string review, double price, int stock)
        {
            ProId = proId;
            Name = name;
            Rating = rating;
            Review = review;
            Price = price;
            Stock = stock;
        }

        public void AddToCart() => Console.WriteLine($"Product '{Name}' added to cart.");

        public void Buy()
        {
            if (Stock > 0)
            {
                Stock--;
                Console.WriteLine($"Purchased {Name}. Remaining stock: {Stock}");
            }
            else
            {
                Console.WriteLine($"Product {Name} is out of stock!");
            }
        }
    }

    public class Categories
    {
        public string CatId { get; set; }
        public string Name { get; set; }
        private List<Product> proList = new List<Product>();

        public Categories(string catId, string name)
        {
            CatId = catId;
            Name = name;
        }

        public void AddProduct(Product product) => proList.Add(product);

        public void SearchByCat()
        {
            Console.WriteLine($"\n--- Category: {Name} ---");
            foreach (var p in proList)
            {
                Console.WriteLine($"- {p.Name} | Price: ${p.Price} | Stock: {p.Stock}");
            }
        }

        public void SortProducts()
        {
            proList = proList.OrderBy(p => p.Price).ToList();
            Console.WriteLine($"Products sorted by price in {Name} category.");
        }
    }

    public class Cart
    {
        public string CartId { get; set; }
        public List<Product> ItemList { get; set; } = new List<Product>();
        public double TotalAmount { get; private set; } = 0.0;

        public Cart(string cartId) => CartId = cartId;

        public void AddProduct(Product product)
        {
            ItemList.Add(product);
            TotalAmount += product.Price;
            Console.WriteLine($"Added to Cart: {product.Name}");
        }

        public void PayNow() => Console.WriteLine($"Proceeding to payment... Total Cart Amount: ${TotalAmount}");
    }

    public class Order
    {
        public string OrderId { get; set; }
        public string OrderStatus { get; set; } = "Pending";
        public double Total { get; set; }
        public string Date { get; set; }
        public string Details { get; set; }

        public Order(string orderId, double total, string date, string details)
        {
            OrderId = orderId;
            Total = total;
            Date = date;
            Details = details;
        }

        public void PlaceOrder()
        {
            OrderStatus = "Placed";
            Console.WriteLine($"Order {OrderId} placed successfully on {Date} for Total: ${Total}");
        }
    }

    public class Payment
    {
        public string PayId { get; set; }
        public string PayMethod { get; set; }
        public double PayAmount { get; set; }
        public string PayStatus { get; set; } = "Initiated";

        public Payment(string payId, string payMethod, double payAmount)
        {
            PayId = payId;
            PayMethod = payMethod;
            PayAmount = payAmount;
        }

        public void CompletePayment()
        {
            PayStatus = "Completed";
            Console.WriteLine($"Payment of ${PayAmount} via {PayMethod} successful!");
        }

        public void CheckStatus() => Console.WriteLine($"Payment ID {PayId} Status: {PayStatus}");
    }

    public class Shipment
    {
        public string ShipId { get; set; }
        public string TrackingNo { get; set; }
        public string DeliStatus { get; set; } = "In Transit";
        public string Date { get; set; }
        public string ShipDate { get; set; }

        public Shipment(string shipId, string trackingNo, string date, string shipDate)
        {
            ShipId = shipId;
            TrackingNo = trackingNo;
            Date = date;
            ShipDate = shipDate;
        }

        public void CheckStatus() => Console.WriteLine($"Shipment Tracking No: {TrackingNo} | Status: {DeliStatus} | Shipped On: {ShipDate}");
    }

    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("==========================================");
            Console.WriteLine("   ONLINE SHOPPING SYSTEM (C# DEMO)      ");
            Console.WriteLine("==========================================");

            Product laptop = new Product("P101", "Gaming Laptop", 4.8f, "Excellent performance", 1200.00, 5);
            Product mouse = new Product("P102", "Wireless Mouse", 4.2f, "Smooth and reliable", 25.50, 15);

            Categories electronics = new Categories("C01", "Electronics");
            electronics.AddProduct(laptop);
            electronics.AddProduct(mouse);

            electronics.SearchByCat();
            electronics.SortProducts();

            Console.WriteLine("\n--- Shopping Cart Operations ---");
            Cart cart = new Cart("CART_001");
            cart.AddProduct(laptop);
            cart.AddProduct(mouse);
            cart.PayNow();

            Console.WriteLine("\n--- Order Management ---");
            Order order = new Order("ORD_9988", cart.TotalAmount, "2026-09-27", "2 Items: Laptop, Mouse");
            order.PlaceOrder();

            Console.WriteLine("\n--- Payment Processing ---");
            Payment payment = new Payment("PAY_7711", "Credit Card", cart.TotalAmount);
            payment.CompletePayment();
            payment.CheckStatus();

            Console.WriteLine("\n--- Shipment Tracking ---");
            Shipment shipment = new Shipment("SHIP_3321", "TRK_99182736", "2026-09-27", "2026-09-28");
            shipment.CheckStatus();

            Console.WriteLine("\n==========================================");
        }
    }
}