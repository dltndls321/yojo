<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Responsive Navigation Trigger -->
	<a href="#" class="dashboard-responsive-nav-trigger"><i class="fa fa-reorder"></i> Dashboard Navigation</a>

	<div class="dashboard-nav">
		<div class="dashboard-nav-inner">

			<ul data-submenu-title="Main">
				<li class="active"><a href="/admin/main"><i class="sl sl-icon-settings"></i> Admin Main</a></li>
			</ul>
			
			<ul data-submenu-title="Listings">
				<li><a href="/admin/board"><i class="sl sl-icon-layers"></i> Board</a></li>
				<li><a href="/admin/course"><i class="sl sl-icon-map"></i>Course</a></li>
				<li><a href="/admin/reviews"><i class="sl sl-icon-star"></i> Review</a></li>
				<li><a href="/admin/course"><i class="sl sl-icon-plus"></i>Add Course</a></li>
			</ul>	

			<ul data-submenu-title="Account">
				<li><a href="/admin/memberList"><i class="sl sl-icon-user"></i> Member List</a></li>
				<li><a href="/member/logout"><i class="sl sl-icon-power"></i> Logout</a></li>
			</ul>
			
		</div>
	</div>