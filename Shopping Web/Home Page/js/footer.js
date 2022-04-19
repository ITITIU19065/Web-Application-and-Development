const createFooter = () =>{
    let footer = document.querySelector('footer');

    footer.innerHTML = `
    <div class="footer-content">
    <img src="./img/light-logo.png" class="logo" alt="">
    <div class="footer-ul-container">
        <ul class="category">
            <li class="category-title">men</li>
            <li> <a href="#" class="footer-link">t-shirts</a> </li>
            <li> <a href="#" class="footer-link">sweat</a> </li>
            <li> <a href="#" class="footer-link">shirts</a> </li>
            <li> <a href="#" class="footer-link">jeans</a> </li>
            <li> <a href="#" class="footer-link">trousers</a> </li>
            <li> <a href="#" class="footer-link">shoes</a> </li>
            <li> <a href="#" class="footer-link">casuals</a> </li>
            <li> <a href="#" class="footer-link">sports</a> </li>
            <li> <a href="#" class="footer-link">formals</a> </li>
            <li> <a href="#" class="footer-link">watch</a> </li>
        </ul>
        <ul class="category">
            <li class="category-title">women</li>
            <li> <a href="#" class="footer-link">t-shirts</a> </li>
            <li> <a href="#" class="footer-link">sweat</a> </li>
            <li> <a href="#" class="footer-link">shirts</a> </li>
            <li> <a href="#" class="footer-link">jeans</a> </li>
            <li> <a href="#" class="footer-link">trousers</a> </li>
            <li> <a href="#" class="footer-link">shoes</a> </li>
            <li> <a href="#" class="footer-link">casuals</a> </li>
            <li> <a href="#" class="footer-link">sports</a> </li>
            <li> <a href="#" class="footer-link">formals</a> </li>
            <li> <a href="#" class="footer-link">watch</a> </li>
        </ul>
    </div>
</div>
<p class="footer-title">about company</p>
    <p class="info">Have you ever been unable to find what
        you're looking for in the main navigation of a website? 
        Have you ever been considering a product on an e-commerce 
        site but been unable to find the return policy? 
        The frustration that this causes prompts some users to leave and 
        find a site that is more transparent or intuitive.</p>
        <p class="info">support email - ngocbao123steam@gmail.com, customersupport - 
            user@clothing.com
        </p>
        <p class="info">telephone - 0933546078(Bao Nguyen)</p>
        <div class="footer-social-container">
            <div>
                <a href="#" class="social-link">terms & services</a>
                <a href="#" class="social-link">privacy page</a>
            </div>
            <div>
                <a href="#" class="social-link">instagram</a>
                <a href="#" class="social-link">facebook</a>
                <a href="#" class="social-link">twitter</a>
            </div>
        </div>
        <p class="footer-credit">Clothing, Best apparels online store</p>
    `;
}
createFooter();