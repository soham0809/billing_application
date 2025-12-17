package in.sohamjoshi.billingsoftware.service;

import in.sohamjoshi.billingsoftware.io.CategoryRequest;
import in.sohamjoshi.billingsoftware.io.CategoryResponse;

public interface CategoryService {
    CategoryResponse add(CategoryRequest request );
}
