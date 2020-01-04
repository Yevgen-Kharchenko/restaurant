<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<footer class="ftco-footer ftco-bg-dark ftco-section">
    <div class="container">
        <div class="row mb-5">
            <div class="col-md">
                <div class="ftco-footer-widget mb-4">
                    <h2 class="ftco-heading-2">Tasty</h2>
                    <p><fmt:message key="far.away"/>.</p>
                    <ul class="ftco-footer-social list-unstyled float-md-left float-lft">
                        <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li>
                        <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li>
                        <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>
                    </ul>
                </div>
            </div>
            <div class="col-md">
                <div class="ftco-footer-widget mb-4">
                    <h2 class="ftco-heading-2"><fmt:message key="opening"/></h2>
                    <ul class="list-unstyled">
                        <li><a href="#" class="py-2 d-block"><fmt:message key="monday"/>: <span>08: - 22:00</span></a></li>
                        <li><a href="#" class="py-2 d-block"><fmt:message key="tuesday"/>: <span>08: - 22:00</span></a></li>
                        <li><a href="#" class="py-2 d-block"><fmt:message key="wednesday"/>: <span>08: - 22:00</span></a></li>
                        <li><a href="#" class="py-2 d-block"><fmt:message key="thursday"/>: <span>08: - 22:00</span></a></li>
                        <li><a href="#" class="py-2 d-block"><fmt:message key="friday"/>: <span>08: - 22:00</span></a></li>
                        <li><a href="#" class="py-2 d-block"><fmt:message key="saturday"/>: <span>08: - 22:00</span></a></li>
                        <li><a href="#" class="py-2 d-block"><fmt:message key="sunday"/>: <span>08: - 22:00</span></a></li>
                    </ul>
                </div>
            </div>
            <div class="col-md">
                <div class="ftco-footer-widget mb-4">
                    <h2 class="ftco-heading-2"><fmt:message key="contact.information"/></h2>
                    <ul class="list-unstyled">
                        <li><a href="#" class="py-2 d-block"><fmt:message key="west"/></a></li>
                        <li><a href="#" class="py-2 d-block">+ 1235 2355 98</a></li>
                        <li><a href="#" class="py-2 d-block">info@yoursite.com</a></li>
                        <li><a href="#" class="py-2 d-block">email@email.com</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-md">
                <div class="ftco-footer-widget mb-4">
                    <h2 class="ftco-heading-2"><fmt:message key="newsletter"/></h2>
                    <p><fmt:message key="far.far"/></p>
                    <form action="#" class="subscribe-form">
                        <div class="form-group">
                            <span class="icon icon-paper-plane"></span>
                            <input type="text" class="form-control" placeholder="<fmt:message key="subscribe"/>">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 text-center">

                <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    <fmt:message key="copyright"/> &copy;<script>document.write(new Date().getFullYear());</script><fmt:message key="rights"/> | This template is made with <i class="icon-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
            </div>
        </div>
    </div>
</footer>