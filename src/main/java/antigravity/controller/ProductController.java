package antigravity.controller;

import antigravity.application.ProductLikeService;
import antigravity.application.ProductService;
import antigravity.application.dto.ProductLikeResponse;
import antigravity.application.dto.ProductResponse;
import antigravity.common.ApiResponse;
import antigravity.common.login.Login;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductLikeService productLikeService;
    private final ProductService productService;

    // 찜 상품 등록 API
    @PostMapping("/{productId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<ProductLikeResponse> registerProductLike(@Login Long loginId, @PathVariable Long productId) {
        return ApiResponse.success(productLikeService.like(loginId, productId));
    }

    // 찜 상품 조회 API
    @GetMapping
    public ApiResponse<Page<ProductResponse>> searchProducts(@Login Long loginId,
                                                             @PageableDefault Pageable pageable,
                                                             @RequestParam Optional<Boolean> liked) {

        return ApiResponse.success(productService.searchProducts(loginId, pageable, liked));
    }

}
