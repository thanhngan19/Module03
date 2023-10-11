<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <!-- ICONS -->
  <script src="https://unpkg.com/@phosphor-icons/web"></script>
  <!-- STYLESHEET -->
  <link rel="stylesheet" href="style.css" />

  <title>Sidebar</title>
</head>
<body>
<div class="container">
  <div class="sidebar">
    <div class="menu-btn">
      <i class="ph-bold ph-caret-left"></i>
    </div>
    <div class="head">
      <div class="user-img">
        <img src="html1.jpg"/>4

      </div>
      <div class="user-details">
        <p class="title">Furama</p>
        <p class="name">thanhngan</p>
      </div>
    </div>
    <div class="nav">
      <div class="menu">
        <p class="title">Main</p>
        <ul>
          <li>
            <a href="#">
              <i class="icon ph-bold ph-user"></i>
              <span class="text">Customer</span>
              <i class="arrow ph-bold ph-caret-down"></i>
            </a>
            <ul class="sub-menu">
              <li>
                <a href="/furama?action=show" onClick="showForm()" target="show"><span class="text">View</span></a>
              </li>
            </ul>
          </li>
          <li>
            <a href="#">
              <i class="icon ph-bold ph-user"></i>
              <span class="text">Service</span>
              <i class="arrow ph-bold ph-caret-down"></i>
            </a>
            <ul class="sub-menu">
              <li>
                <a href="#">
                  <span class="text">Add New Service</span>
                </a>
              </li>
            </ul>
          </li>
          <li>
            <a href="#">
              <i class="icon ph-bold ph-user"></i>
              <span class="text">Employee</span>
              <i class="arrow ph-bold ph-caret-down"></i>
            </a>
            <ul class="sub-menu">
              <li>
                <a href="/furama?action=showFormEmployee" onClick="showForm()" target="show"><span class="text">View</span></a>
              </li>
              <li>
                <a href="/furama?action=showFormCreate" onClick="showForm()" target="show"><span class="text">Add</span></a>

                </a>
              </li>
              <li>
                <a href="/furama?action=showFormDelete" onClick="showForm()" target="show"><span class="text">Delete</span></a>

                </a>
              </li>
              <li>
                <a href="/furama?action=showFormEdited" onClick="showForm()" target="show"><span class="text">Edit</span></a>
                </a>
              </li>
              <li>
                <a href="/furama?action=showFormSearch" onClick="showForm()" target="show"><span class="text">Search</span></a>
                </a>
              </li>





            </ul>
          </li>
          <li>
            <a href="#">
              <i class="icon ph-bold ph-user"></i>
              <span class="text">Contract</span>
              <i class="arrow ph-bold ph-caret-down"></i>
            </a>
            <ul class="sub-menu">
              <li>
                <a href="#">
                  <span class="text">Add Contract Deatail</span>
                </a>
              </li>
              <li>
                <a href="#">
                  <span class="text">Add Contract </span>
                </a>
              </li>
            </ul>
          </li>
          <li>
            <a href="#">
              <i class="icon ph-bold ph-chart-bar"></i>
              <span class="text">DashBoard</span>
              <i class="arrow ph-bold ph-caret-down"></i>
            </a>
            <ul class="sub-menu">
              <li>
                <a href="#">
                  <span class="text">Earnings</span>
                </a>
              </li>
              <li>
                <a href="#">
                  <span class="text">Funds</span>
                </a>
              </li>
              <li>
                <a href="#">
                  <span class="text">Declines</span>
                </a>
              </li>
              <li>
                <a href="#">
                  <span class="text">Payouts</span>
                </a>
              </li>
            </ul>
          </li>
        </ul>
      </div>
      <div class="menu">
        <p class="title">Settings</p>
        <ul>
          <li>
            <a href="#">
              <i class="icon ph-bold ph-gear"></i>
              <span class="text">Settings</span>
            </a>
          </li>
        </ul>
      </div>
    </div>
    <div class="menu">
      <p class="title">Account</p>
      <ul>
        <li>
          <a href="#">
            <i class="icon ph-bold ph-info"></i>
            <span class="text">Help</span>
          </a>
        </li>
        <li>
          <a href="#">
            <i class="icon ph-bold ph-sign-out"></i>
            <span class="text">Logout</span>
          </a>
        </li>
      </ul>
    </div>
  </div>
  <div class="credits">
    <iframe src="" frameborder="0" class="showForm" name="show"  width="1253px" height="735px"></iframe>
  </div>
</div>

<!-- Jquery -->
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.0/jquery.js"
        integrity="sha512-8Z5++K1rB3U+USaLKG6oO8uWWBhdYsM3hmdirnOEWp8h2B1aOikj5zBzlXs8QOrvY9OxEnD2QDkbSKKpfqcIWw=="
        crossorigin="anonymous"
></script>
<script src="script.js"></script>
</body>
</html>
