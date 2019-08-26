<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="dashboard-content">

		<!-- Titlebar -->
		<div id="titlebar">
			<div class="row">
				<div class="col-md-12">
					<h2>Messages</h2>
					<!-- Breadcrumbs -->
					<nav id="breadcrumbs">
						<ul>
							<li><a href="/main/main">Home</a></li>
							<li><a href="/abmin/main">Admin</a></li>
							<li>Customer Center Message</li>
						</ul>
					</nav>
				</div>
			</div>
		</div>

		<div class="row">
			
			<!-- Listings -->
			<div class="col-lg-12 col-md-12">

				<div class="messages-container margin-top-0">
					<div class="messages-headline">
						<h4>문의자 이름</h4>
						<a href="#" class="message-action"><i class="sl sl-icon-trash"></i> Delete Conversation</a>
					</div>

					<div class="messages-container-inner">

						<!-- Messages -->
						<div class="messages-inbox">
							<ul>
								<li class="active-message">
									<a href="/admin/customerCenterMessage">
										<div class="message-avatar"><img src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=70" alt="" /></div>

										<div class="message-by">
											<div class="message-by-headline">
												<h5>1번사람</h5>
												<span>2 시간 전</span>
											</div>
											<p> 문의 내용 .. </p>
										</div>
									</a>
								</li>

								<li>
									<a href="/admin/customerCenterMessage">
										<div class="message-avatar"><img src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=70" alt="" /></div>

										<div class="message-by">
											<div class="message-by-headline">
												<h5>2번사람 <i>안읽음</i></h5>
												<span>4 시간 전</span>
											</div>
											<p> 문의 내용 .. </p>
										</div>
									</a>
								</li>

							</ul>
						</div>
						<!-- Messages / End -->

						<!-- Message Content -->
						<div class="message-content">

							<div class="message-bubble">
								<div class="message-avatar"><img src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=70" alt="" /></div>
								<div class="message-text"><p>호엥 호엥</p></div>
							</div>

							<div class="message-bubble me">
								<div class="message-avatar"><img src="images/dashboard-avatar.jpg" alt="" /></div>
								<div class="message-text"><p>후엥 후엥</p></div>
							</div>

							<div class="message-bubble me">
								<div class="message-avatar"><img src="images/dashboard-avatar.jpg" alt="" /></div>
								<div class="message-text"><p>호엥 후엥</p></div>
							</div>

							<div class="message-bubble">
								<div class="message-avatar"><img src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=70" alt="" /></div>
								<div class="message-text"><p>후엥 호엥</p></div>
							</div>

							<!-- Reply Area -->
							<div class="clearfix"></div>
							<div class="message-reply">
								<textarea cols="40" rows="3" placeholder="Your Message"></textarea>
								<button class="button">Send Message</button>
							</div>
							
						</div>
						<!-- Message Content -->

					</div>

				</div>

			</div>

			<!-- Copyrights -->
			<div class="col-md-12">
				<div class="copyrights">© 2019 Listeo. All Rights Reserved.</div>
			</div>
		</div>

	</div>