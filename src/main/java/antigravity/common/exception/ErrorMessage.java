package antigravity.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ErrorMessage {

    DUPLICATE_LIKE("이미 찜한 상품입니다."),
    NOT_FOUND_USER("등록된 회원이 아닙니다."),
    NOT_FOUND_PRODUCT("등록된 상품이 아닙니다.");


    private final String message;
}
