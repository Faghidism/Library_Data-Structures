# Library Management System 

![Image](https://github.com/user-attachments/assets/704be4d7-ae46-4333-8986-30dd91c3a5a6)

## Project Overview
A complete library management system implementing custom data structures for book organization and order processing.

## Core Features

### Book Categorization System
- **Tree-based category hierarchy**
  - Add/remove categories and subcategories
  - Book storage in category nodes
  - Recursive deletion of categories

### Order Processing
- **Priority-based ordering system**
  - Max heap implementation
  - Priority rules:
    - Higher price = Higher priority
    - Equal price = Earlier order first
  - Real-time order processing

## Command List

### Admin Commands
| Command | Description |
|---------|-------------|
| `add category <name>` | Create new category |
| `add subcategory <child> to <parent>` | Add nested category |
| `add book <title> by <author> ($<price>) to <category>` | Add new book |
| `remove book <title> from <category>` | Remove book |
| `remove category <name>` | Remove category |

### User Commands
| Command | Description |
|---------|-------------|
| `search <book>` | Find book details |
| `list books` | Show all books |
| `list books from <category>` | Filter by category |
| `order <book>` | Place order |
| `list orders` | View/process orders |

## Bonus Features

### Shopping Cart System
- User-specific carts
- Price-sorted items (max heap)
- Order history tracking
- User commands:
  - `user <ID> add <book>`
  - `user <ID> order`
  - `order log of <ID>`

## Technical Specifications

### Implemented Data Structures
1. **Category Tree**
   - N-ary tree structure
   - Dynamic node insertion/deletion

2. **Order Max Heap**
   - Priority queue implementation
   - Array-based storage

3. **Order History**
   - Linked list implementation
   - Sequential access pattern

## Project Constraints
- ❌ No built-in data structures
- ❌ No GUI implementation
- ✅ Manual DS implementation required
- ✅ Any programming language allowed

## Sample Workflow

1. Admin creates categories:
