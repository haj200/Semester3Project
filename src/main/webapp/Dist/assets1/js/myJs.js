/**
 * 
 */

document.addEventListener("DOMContentLoaded", function () {
    // Handle Login Button Visibility
    const currentUrl = window.location.pathname; // Get the current path
    const loginButton = document.getElementById("login-btn");
    if (currentUrl === "/Semester3Project/login") {
        loginButton.style.visibility = "hidden"; // Keeps the space of the button while hiding it
    }

    // Mobile Navigation Toggle
    const mobileNavToggle = document.querySelector('.mobile-nav-toggle');
    const navMenu = document.querySelector('#navmenu');

    mobileNavToggle.addEventListener('click', () => {
        document.body.classList.toggle('mobile-nav-active');
        mobileNavToggle.classList.toggle('bi-list');
        mobileNavToggle.classList.toggle('bi-x');
    });

    // Dropdowns in Navigation
    const dropdownLinks = document.querySelectorAll('.dropdown > a');
    dropdownLinks.forEach(link => {
        link.addEventListener('click', (e) => {
            e.preventDefault();
            link.classList.toggle('active');
            const dropdownMenu = link.nextElementSibling;
            if (dropdownMenu) {
                dropdownMenu.style.display = dropdownMenu.style.display === 'block' ? 'none' : 'block';
            }
        });
    });

  
 



});




