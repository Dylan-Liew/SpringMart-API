# SpringMart-API
SpringMart API is a lightweight and efficient RESTful web service designed for managing the inventory of an online supermarket.

## CRUD Operations
### 1. Product Management
Manage products in the inventory.

| **Operation**      | **HTTP Method** | **Endpoint**          | **Access Level**   | **Description**                                             |
|---------------------|-----------------|-----------------------|--------------------|-------------------------------------------------------------|
| Create Product      | POST            | `/api/products`       | Admin              | Add new products to the inventory.                         |
| Update Product      | PUT             | `/api/products/{id}`  | Admin              | Update product details (e.g., price, stock).               |
| Delete Product      | DELETE          | `/api/products/{id}`  | Admin              | Remove a product from the inventory.                       |
| View All Products   | GET             | `/api/products`       | Admin, Normal User | Retrieve a list of all products.                           |
| View Product (One)  | GET             | `/api/products/{id}`  | Admin, Normal User | Retrieve details of a specific product.                    |
| Manage Stock Levels | PATCH           | `/api/products/{id}`  | Admin              | Adjust stock levels for a product (add or reduce stock).   |

---

### 2. User Management (Admin-Specific)
Manage users and roles.

| **Operation**      | **HTTP Method** | **Endpoint**         | **Access Level** | **Description**                                             |
|---------------------|-----------------|----------------------|------------------|-------------------------------------------------------------|
| Create User         | POST            | `/api/users`         | Admin            | Register a new user and assign roles (Admin, Normal User).  |
| View All Users      | GET             | `/api/users`         | Admin            | Retrieve a list of all users.                               |
| View User (One)     | GET             | `/api/users/{id}`    | Admin            | Retrieve details of a specific user by ID.                 |
| Update User         | PUT             | `/api/users/{id}`    | Admin            | Update user details or roles.                              |
| Delete User         | DELETE          | `/api/users/{id}`    | Admin            | Remove a user from the system.                             |

---

### 3. Authentication and Authorization
Secure the API using JWT-based authentication.

| **Operation** | **HTTP Method** | **Endpoint**       | **Access Level**   | **Description**                                             |
|---------------|-----------------|--------------------|--------------------|-------------------------------------------------------------|
| Register      | POST            | `/api/auth/register` | Public            | Allow new users to sign up with a default "Normal User" role. |
| Login         | POST            | `/api/auth/login` | Admin, Normal User | Authenticate users and generate JWT tokens.                |
| Get User Info | GET             | `/api/auth/me`    | Admin, Normal User | Retrieve details of the currently authenticated user.       |

---

## Authentication and Role-Based Access Control (RBAC)
### Roles
1. **Admin**: Full access to all endpoints, including managing users and inventory.
2. **Normal User**: Limited access to view product details but cannot manage inventory or users.

### Implementation Details
- **JWT Authentication**: Use JSON Web Tokens to secure endpoints.
- **Role-Based Access Control**: Restrict access using roles (`ROLE_ADMIN`, `ROLE_USER`).
