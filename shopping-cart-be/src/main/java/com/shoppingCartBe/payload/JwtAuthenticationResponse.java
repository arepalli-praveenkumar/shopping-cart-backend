/**
 * 
 */
package com.shoppingCartBe.payload;

import com.shoppingCartBe.models.User;
import com.shoppingCartBe.security.UserPrincipal;

/**
 * @author praveen
 *
 */
public class JwtAuthenticationResponse {

	private String accessToken;
    private String tokenType = "Bearer";
    private User currentUser;
    private UserPrincipal userPrincipal;

    public JwtAuthenticationResponse(String accessToken, User currentUser) {
        this.accessToken = accessToken;
        this.currentUser = currentUser;
    }
    
    public JwtAuthenticationResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    public JwtAuthenticationResponse(String accessToken, UserPrincipal userPrincipal) {
		// TODO Auto-generated constructor stub
    	this.accessToken = accessToken;
        this.userPrincipal = userPrincipal;
	}

	public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

	/**
	 * @return the currentUser
	 */
	public User getCurrentUser() {
		return currentUser;
	}

	/**
	 * @param currentUser the currentUser to set
	 */
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	/**
	 * @return the userPrincipal
	 */
	public UserPrincipal getUserPrincipal() {
		return userPrincipal;
	}

	/**
	 * @param userPrincipal the userPrincipal to set
	 */
	public void setUserPrincipal(UserPrincipal userPrincipal) {
		this.userPrincipal = userPrincipal;
	}
}
