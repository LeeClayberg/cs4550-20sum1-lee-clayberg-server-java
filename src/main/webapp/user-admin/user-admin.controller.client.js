(function () {
  let $tbody, $addBtn, $updateBtn, $searchBtn
  let $usernameFld, $passwordFld, $firstFld, $lastFld, $roleFld
  let $template
  let service = new AdminUserServiceClient()
  let selectedUser = {}

  function main() {
    $tbody = $('tbody')
    $addBtn = $('.wbdv-create')
    $updateBtn = $('.wbdv-update')
    $searchBtn = $('.wbdv-search')

    const temp = $('.wbdv-template')[0]
    $template = $(temp)

    $addBtn.click(createUser)
    $updateBtn.click(updateUser)
    $searchBtn.click(searchUser)

    $usernameFld = $('.wbdv-username-fld')
    $passwordFld = $('.wbdv-password-fld')
    $firstFld = $('.wbdv-first-fld')
    $lastFld = $('.wbdv-last-fld')
    $roleFld = $('.wbdv-role-fld')

    findAllUsers()
  }

  function createUser() {
    if($roleFld.val() != '') {
      const username = $usernameFld.val()
      const password = $passwordFld.val()
      const first = $firstFld.val()
      const last = $lastFld.val()
      const role = $roleFld.val()

      const newUser = {
        username: username,
        password: password,
        first: first,
        last: last,
        role: role
      }

      service.createUser(newUser)
          .then(function (status) {
            findAllUsers()
          })

      document.getElementById('failureAlert').classList.add('hidden');
    } else {
      document.getElementById('failureAlert').classList.remove('hidden');
    }
  }

  function searchUser() {
    service.findAllUsers()
        .then(function (allUsers) {
          let users = allUsers.filter(function(user) {
            if($usernameFld.val() != '' && !user.username.includes($usernameFld.val())) {
              return false;
            }
            if($passwordFld.val() != '' && !user.password.includes($passwordFld.val())) {
              return false;
            }
            if($firstFld.val() != '' && !user.first.includes($firstFld.val())) {
              return false;
            }
            if($lastFld.val() != '' && !user.last.includes($lastFld.val())) {
              return false;
            }
            if($roleFld.val() != '' && user.role != $roleFld.val()) {
              return false;
            }
            return true;
          });
          renderUsers(users)
        })
  }

  function findAllUsers() {
    service.findAllUsers()
        .then(function (allUsers) {
          renderUsers(allUsers)
        })
  }

  function findUserById(userId) {
    service.findUserById(userId)
        .then(function (user) {
          renderUser(user)
        })
  }

  function deleteUser(event) {
    const target = event.currentTarget
    const $button = $(target)
    const userId = $button.attr('id')
    service.deleteUser(userId)
      .then(function(status) {
        findAllUsers()
      })
  }

  function selectUser(event) {
    const target = event.currentTarget
    const $button = $(target)
    const userId = $button.attr('id')
    findUserById(userId)
  }

  function updateUser() {
    const updatedUser = {
      _id: selectedUser._id,
      username: $usernameFld.val(),
      password: $passwordFld.val(),
      first: $firstFld.val(),
      last: $lastFld.val(),
      role: $roleFld.val()
    }
    service.updateUser(selectedUser._id, updatedUser)
        .then(function(status) {
          findAllUsers()
        })
  }

  function renderUser(user) {
    selectedUser = user
    $usernameFld.val(user.username)
    $passwordFld.val(user.password)
    $firstFld.val(user.first)
    $lastFld.val(user.last)
    $roleFld.val(user.role)
  }

  function renderUsers(users) {
    const clone = $template.clone()
    $tbody.empty()

    for(let i=0; i<users.length; i++) {
      const user = users[i]
      const copy = clone.clone()
      copy.find('.wbdv-username').html(user.username)
      copy.find('.wbdv-password').html(user.password)
      copy.find('.wbdv-first-name').html(user.first)
      copy.find('.wbdv-last-name').html(user.last)
      copy.find('.wbdv-role').html(user.role)
      copy.find('.wbdv-remove')
        .attr('id', user._id)
        .click(deleteUser)
      copy.find('.wbdv-edit')
        .attr('id', user._id)
        .click(selectUser)
      $tbody.append(copy)
    }
  }

  jQuery(main)

})()
