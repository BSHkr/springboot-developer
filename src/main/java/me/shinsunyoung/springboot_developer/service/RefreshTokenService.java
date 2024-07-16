package me.shinsunyoung.springboot_developer.service;

import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springboot_developer.domain.RefreshToken;
import me.shinsunyoung.springboot_developer.repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken findByRefreshToken(String refreshToken) {
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected token"));
    }
}
