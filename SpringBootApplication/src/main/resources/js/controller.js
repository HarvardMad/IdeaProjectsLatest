/**
 * Created by LalinPethiyagoda on 28/01/2017.
 */

var cartApp = angular.module("cartApp", []);

cartApp.controller("cartCtrl", function($scope,$http){

    $scope.refreshCart = function(){
        $http.get("/WeIndian/rest/cart/"+$scope.cartId).success(function(data){

            $scope.cart=data;
        });
    };

    $scope.clearCart= function(){
        $http.delete("/WEIndian/rest/cart/"+$scope.cartId).success($scope.refreshCart());
    }

    $scope.initCartId = function(cartId){
        $scope.cartId = cartId;
        $scope.refreshCart(cartid);

    };

    $scope.addCart= function(productId){
        $http.put("/WEIndian/rest/cart/add/"+productId).success(function(){
            $scope.refreshCart($http.get("/WEIndian/cart/cartId"));
            alert("Product successfully added to the cart")
        });
    };

    $scope.removeFromCart= function(productId){
        $http.put("/WEIndian/rest/cart/remove/"+productId).success(function(data){
           $scope.refreshCart();
        });
    }


    $scope.calGrandTotal = function () {
        var grandTotal=0;

        for (var i=0; i<$scope.cart.cartItems.length; i++) {
            grandTotal+=$scope.cart.cartItems[i].totalPrice;
        }

        return grandTotal;
    };
});