```
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Film product = (Film) o;
        return (this.id != null) && (product.getId() != null) && this.id.equals(product.getId());
    }
    
    @Override
    public int hashCode() {
        return this.id != null ? this.id.hashCode() : 0;
    }
    
    public Category getCategory() {
        return category;
    }
    
    public void setCategory(Category category) {
        if (sameAsFormer(category)) return;
        Category oldCategory = this.category;
        this.category = category;
        if (oldCategory != null) {
            oldCategory.remove(this);
        }

        if (category != null) {
            category.add(this);
        }
    }
    
    private boolean sameAsFormer(Category newCategory) {
        return (this.category == null) ? (newCategory == null) : (this.category.equals(newCategory));
    }

```

```
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;
        return (this.id != null) && (category.getId() != null) && this.id.equals(category.getId());
    }
    
    @Override
    public int hashCode() {
        return this.id != null ? this.id.hashCode() : 0;
    }
    
    public Collection<Product> getProducts() {
        return new ArrayList<>(products);
    }
    
    public void add(Product product) {
        if (this.products.contains(product)) return;
        this.products.add(product);
        product.setCategory(this);
    }
    
    public void remove(Product product) {
        if (!this.products.contains(product)) return;
        this.products.remove(product);
        product.setCategory(null);
    }
```

```
    //Case1
    Category category1 = categoryRepository.save(new Category("cat1"));
    Product product1 = Product.builder().name("product1").publishedDate(OffsetDateTime.now()).country("USA").duration(120).build();
    product1.setCategory(category1);
    Product product2 = Product.builder().name("product2").publishedDate(OffsetDateTime.now()).country("VN").duration(90).build();
    product2.setCategory(category1);
    filmRepository.save(Arrays.asList(product1, product2));
    
    //Case2
    Product product1 = filmRepository.save(new Product("product1"));
    Product product2 = filmRepository.save(new Product("product2"));
    Category category = new Category("cat1");
    category.add(product1);
    category.add(product2);
    categoryRepository.save(category);
    filmRepository.save(Arrays.asList(product1, product2));
```