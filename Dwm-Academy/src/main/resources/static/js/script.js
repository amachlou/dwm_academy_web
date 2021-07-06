$( document ).ready(function() {
  
    const editProfile=$('#edit-profile');
    const saveProfile=$('#save-profile');
    const cancelProfileForm=$('.cancel-profile-form');
    const cancelCourseForm=$('.cancel-course-form');


    const addContent=$('#add-content');
    const addContent2=$('#add-content2');
    const addCourse=$('#add-course');

    const profileDescription=$('#profile-description');
    const profileForm=$('#profile-form');

    const contentForm=$('#content-form');
    const addContentContainer=$('#add-content-container');
    const contentContainer=$('#content-container');

    $(editProfile).on('click',()=>{
      profileDescription.addClass('uk-hidden');
      profileForm.removeClass('uk-hidden');
      UIkit.switcher('.dashboard-tab').show(0);
    });

    $(saveProfile).on('click',()=>{
        profileForm.addClass('uk-hidden');
        profileDescription.removeClass('uk-hidden');
      });

      $(addContent).on('click',()=>{
        addContentContainer.addClass('uk-hidden');
        contentContainer.addClass('uk-hidden');
        contentForm.removeClass('uk-hidden');
        UIkit.switcher('.dashboard-tab').show(1);  
      });

      $(addContent2).on('click',()=>{
        addContentContainer.addClass('uk-hidden');
        contentContainer.addClass('uk-hidden');
        contentForm.removeClass('uk-hidden');
      });

      $(addCourse).on('click',()=>{
        contentForm.addClass('uk-hidden');
        contentContainer.removeClass('uk-hidden');
      });

      
      $(cancelProfileForm).on('click',()=>{
        profileForm.addClass('uk-hidden');
        profileDescription.removeClass('uk-hidden');
      });

      $(cancelCourseForm).on('click',()=>{
        contentForm.addClass('uk-hidden');
        addContentContainer.removeClass('uk-hidden');
      });


      // ! content table

      const addContentTable=$('#add-content-table');
      
      const contentInfoContainer=$('#content-info-container');
      const contentTableContainer=$('#content-table-container');

    

     
      
      $(addContentTable).on('click',()=>{

        let inputTitle=$('#title-content').val();
        let inputDuration=$('#duration-content').val();
        let inputUrl=$('#video').val();

        contentTableContainer.removeClass('uk-hidden');
        
        contentInfoContainer.append(`<tr id="content-element">
        <td>${inputTitle}</td>
        <td>${inputUrl}</td>
        <td>${inputDuration}</td>
        <td><a uk-icon="icon: trash;" id="remove-content"
                class="uk-text-danger uk-align-right"></a></td>
    </tr>`);
// todo
        inputTitle=$('#title-content').val('');
        inputDuration=$('#duration-content').val('');
        inputUrl=$('#video').val('');

      });
   
      $(document).on('click','#remove-content',()=>{
        console.log('btn clicked');
        $('#content-element').remove();
        if(contentInfoContainer.children().length > 0 ){
          contentTableContainer.removeClass('uk-hidden');
        }
   
      });

      $('#category-name').html($('#categorie-list ul li a').first().html());


      $(document).on('click','#categorie-list ul li',function(){
        let categoryName=$('#category-name');
        
        let categoryValue=$(this).children().html();
        $(categoryName).html(categoryValue);
     
        $('#categorie-list ul li').removeClass('active');
        $('#categorie-list ul li a').removeClass('active');
        $('#categorie-list ul li span').removeClass('active');
    
        $(this).addClass('active');
        $(this).children().addClass('active');
    
      });

      $(".search-form").on('submit',function(e) {
        e.preventDefault();
        let searchName=$('#search-name');
        let searchValue=$('.search-value').val();
        $(searchName).html(searchValue);
        
    });

    //! Modal Switch

    const signinBtn=$('.signin-btn');
    const signupBtn=$('.signup-btn');

    const signupContainer=$('.signup-container');
    const signinContainer=$('.signin-container');


    $(signinBtn).on('click',()=>{
        signinContainer.removeClass('uk-hidden');
        signupContainer.addClass('uk-hidden');
        console.log('clicked');
    });

    $(signupBtn).on('click',()=>{
      signupContainer.removeClass('uk-hidden');
      signinContainer.addClass('uk-hidden');
      console.log('clicked');
 
    });

    
    // ! delete instructor element

    const deleteBtn = $('.delete-btn');

    const instructorElement=$('#instructor-element');

   
    $(deleteBtn).on('click',()=>{
      if($('.checkbox-table').is(':checked')){

       $(instructorElement).remove();

      }
    });

    
  });
 


   
  const player = new Plyr('#player');