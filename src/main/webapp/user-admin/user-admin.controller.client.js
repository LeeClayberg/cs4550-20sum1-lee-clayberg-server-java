(function () {
  let $tbody, $addBtn, $updateBtn
  let $usernameFld, $passwordFld, $firstFld, $lastFld, $roleFld
  let service = new AdminUserServiceClient()
  let selectedUser = {}

  function main() {
    $tbody = $('tbody')
    $addBtn = $('.wbdv-create')

    //possibly add search
    $addBtn.click(createUser)
    $updateBtn.click(updateUser)

    $usernameFld = $('.wbdv-username-fld')
    $passwordFld = $('.wbdv-password-fld')
    $firstFld = $('.wbdv-first-fld')
    $lastFld = $('.wbdv-last-fld')
    $roleFld = $('.wbdv-role-fld')

    findAllUsers()
  }

  function createUser() {
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
        .then(function () {
          findAllUsers()
        })
  }

  function findAllUsers() {
    service.findAllUsers()
        .then(function (allUsers) {
          let users = allUsers
          renderUsers(users)
        })
  }

  function findUserByID(userId) {
    service.findUserById(userId)
        .then(function (user) {
          renderUser(user)
        })
  }

  function deleteUser(event) {
    console.log(event)
    const target = event.currentTarget
    const $button = $(target)
    const userId = $button.attr('id')
    // alert('delete user ' + userId)
    service.deleteUser(userId)
      .then(function() {
        users = users.filter(function(user) {
          return user._id !== userId
        })
        renderAllUsers()
      })
  }

  function selectUser(event) {
    const target = event.currentTarget
    const $button = $(target)
    const userId = $button.attr('id')
    findUserByID(userId)
  }

  function updateUser() {
    const updatedUser = {
      _id: selectedUser._id,
      username: $usernameFld.val(),
      first: $firstFld.val(),
      last: $lastFld.val()
    }
    service.updateUser(selectedUser._id, updatedUser)
        .then(function(status) {
          users = users.map(function(user) {
            if(user._id === selectedUser._id) {
              return updatedUser
            } else {
              return user
            }
          })
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
    // console.log('rendering all users')
    // console.log(users)
    const template = $('.wbdv-template')[0]
    const $template = $(template)
    const clone = $template.clone()
    // console.log($template)
    $tbody.empty()
    for(let i=0; i<users.length; i++) {
      const user = users[i]
      // console.log(user)
      const copy = clone.clone()
      // copy.removeClass('wbdv-user-row-template')
      copy.find('.wbdv-username').html(user.username)
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
