<%-- 
    Document   : movie
    Created on : Feb 26, 2024, 10:54:33 AM
    Author     : DAO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form id="movieForm" method="post">

    <fieldset>
        <legend>
            Default Form Elements
        </legend>
        <div class="form-group">
            <div class="row">
                <div class="col-md-8">
                    <label class="control-label">Movie title</label>
                    <input type="text" class="form-control" name="title" />
                </div>

                <div class="col-md-4 selectContainer">
                    <label class="control-label">Genre</label>
                    <select class="form-control" name="genre">
                        <option value="">Choose a genre</option>
                        <option value="action">Action</option>
                        <option value="comedy">Comedy</option>
                        <option value="horror">Horror</option>
                        <option value="romance">Romance</option>
                    </select>
                </div>
            </div>
        </div>
    </fieldset>

    <fieldset>
        <div class="form-group">
            <div class="row">
                <div class="col-sm-12 col-md-4">
                    <label class="control-label">Director</label>
                    <input type="text" class="form-control" name="director" />
                </div>

                <div class="col-sm-12 col-md-4">
                    <label class="control-label">Writer</label>
                    <input type="text" class="form-control" name="writer" />
                </div>

                <div class="col-sm-12 col-md-4">
                    <label class="control-label">Producer</label>
                    <input type="text" class="form-control" name="producer" />
                </div>
            </div>
        </div>
    </fieldset>

    <fieldset>
        <div class="form-group">
            <div class="row">
                <div class="col-sm-12 col-md-6">
                    <label class="control-label">Website</label>
                    <input type="text" class="form-control" name="website" />
                </div>

                <div class="col-sm-12 col-md-6">
                    <label class="control-label">Youtube trailer</label>
                    <input type="text" class="form-control" name="trailer" />
                </div>
            </div>
        </div>
    </fieldset>

    <fieldset>
        <div class="form-group">
            <label class="control-label">Review</label>
            <textarea class="form-control" name="review" rows="8"></textarea>
        </div>
    </fieldset>

    <fieldset>
        <div class="form-group">

            <div class="row">
                <div class="col-sm-12 col-md-12">
                    <label class="control-label">Rating</label>
                </div>

                <div class="col-sm-12 col-md-10">

                    <label class="radio radio-inline no-margin">
                        <input type="radio" name="rating" value="terrible" class="radiobox style-2" />
                        <span>Terrible</span> </label>

                    <label class="radio radio-inline">
                        <input type="radio" name="rating" value="watchable" class="radiobox style-2" />
                        <span>Watchable</span> </label>
                    <label class="radio radio-inline">
                        <input type="radio" name="rating" value="best" class="radiobox style-2" />
                        <span>Best ever</span> </label>

                </div>

            </div>

        </div>
    </fieldset>

    <div class="form-actions">
        <div class="row">
            <div class="col-md-12">
                <button class="btn btn-default" type="submit">
                    <i class="fa fa-eye"></i>
                    Validate
                </button>
            </div>
        </div>
    </div>

</form>
