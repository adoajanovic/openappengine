# Document High Level Process #



## Sales Order Inventory ##

### Inventory - Add Maintain Inventory ###

1. When we create Sales Order Detail Lines - Validation ---

After entering Item Number, Program should auto get information from Inventory Availability  Also Check Status of inventory line


if it is greater than quantity required Display Error or Warning...
otherwise on completion of Sales Order Available Qnty = Available Qnty - Ordered Qunatity
Commited Quantity += Ordered Qnty


If you get more than 1 line from Invetory Master -- Get Item from Max Availability

