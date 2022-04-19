const productImage = document.querySelectorAll(".product-images img");
const productImageSlide = document.querySelector(".image-slider");

let activeImageSlide = 0;

productImage.forEach((item,i)=>{
    item.addEventListener('click', () =>{
        productImage[activeImageSlide].classList.remove('active');
        item.classList.add('active');
        productImageSlide.style.backgroundImage = `url('${item.src}')`;
        activeImageSlide = i;
    })
})
const sizeBtn = document.querySelectorAll('.size-radio-btn');
let checkBtn = 0;

sizeBtn.forEach((item,i) => {
    item.addEventListener('click', () => {
        sizeBtn[checkBtn].classList.remove('check');
        item.classList.add('check');
        checkBtn = i;
    })
})