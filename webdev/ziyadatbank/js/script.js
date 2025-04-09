const carousel = document.getElementById('carousel');
const dots = document.querySelectorAll('.dot');
let index = 0;
const testimonials = document.querySelectorAll('.testimonial');

const showSlide = (i) => {
  index = (i + testimonials.length) % testimonials.length;
  carousel.style.transform = `translateX(${-index * 100}%)`;

  dots.forEach(dot => dot.classList.remove('active'));
  dots[index].classList.add('active');
};

document.getElementById('next').addEventListener('click', () => {
  showSlide(index + 1);
});

document.getElementById('prev').addEventListener('click', () => {
  showSlide(index - 1);
});

dots.forEach((dot, i) => {
  dot.addEventListener('click', () => showSlide(i));
});

// Auto-slide every 5 seconds
setInterval(() => {
  showSlide(index + 1);
}, 5000);


document.addEventListener('DOMContentLoaded', () => {
    const loginBtn = document.getElementById('loginBtn');
  
    loginBtn.addEventListener('click', () => {
        console.log('Login button clicked');
        const form = document.getElementById('login');
        form.style.display = 'flex';
    });
  });
  