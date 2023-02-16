package com.example.demo;



import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

/**
 * Filter responsible for getting the api key off of incoming requests that need to be authorized.
 */
public class Authentication extends AbstractPreAuthenticatedProcessingFilter {

    private final String headerName;

    public Authentication(final String headerName) {
        this.headerName = headerName;
    }

    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        return request.getHeader(headerName);
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
        // No credentials when using API key
        return null;
    }
}