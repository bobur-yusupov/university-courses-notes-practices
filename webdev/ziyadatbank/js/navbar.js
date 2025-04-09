const hamburger = document.querySelector("#hamburgerHeader");
const navMenu = document.querySelector("#navbarMobile");

const closeBtn = document.querySelector("#closeNavbarMobile");

hamburger.addEventListener("click", () => {
    navMenu.classList.toggle("visible");
    navMenu.classList.toggle("hidden");
    console.log("Hamburger clicked");
});
closeBtn.addEventListener("click", () => {
    navMenu.classList.toggle("visible");
    navMenu.classList.toggle("hidden");
});
