package me.shinsunyoung.springboot_developer.controller;

import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springboot_developer.dto.CreateAccessTokenRequest;
import me.shinsunyoung.springboot_developer.dto.CreateAccessTokenResponse;
import me.shinsunyoung.springboot_developer.service.TokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TokenApiController {

    private final TokenService tokenService;

    @PostMapping("/api/token")
    public ResponseEntity<CreateAccessTokenResponse> createNewAccessToken(@RequestBody CreateAccessTokenRequest request) throws IllegalAccessException {
        String newAccessToken = tokenService.createNewAccessToken(request.getRefreshToken());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new CreateAccessTokenResponse(newAccessToken));
    }
}
