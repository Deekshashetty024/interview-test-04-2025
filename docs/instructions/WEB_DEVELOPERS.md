# Instructions (Web Developers)

## Pre-requisites

Please fork this repo to your own GitHub account.

## Requirements

Users should be able to add reviews for a movie using the web app. When adding a
review, the user should be required to provide a rating between 1 and 5, and
should also be prompted to enter a textual review of the movie. Each user can
only provide a single review for a given movie, so the UI should not allow a
user to submit a review for a movie they have already reviewed.

## Submission

Please commit your changes and push them to GitHub. Once you've pushed your changes,
please send a link to your branch to ben@kmbal.com and malik@kmbal.com. Candidates
are requested **not to raise a pull request** against the main repository.

## Developer Guidance

### Running the Web Application Locally

1. Open the development container in VS Code
2. Change directory to `./web`
3. Copy `.env.example` to `.env` with `cp .env.example .env`
4. Install dependencies with `npm install` and `composer install`
5. Run the database migrations with `php artisan migrate`
6. Seed the database with `php artisan db:seed`
7. Start the Vite development server with `npm run dev`
8. Start the Laravel development server with `php artisan serve`
9. Visit `http://localhost:8000/register` and create an account

### Web Application Architecture

The web application uses Laravel and PHP on the backend. Inertia with React are
used for client side interactivity. Tailwind classes are used for styling. There
is no component library, and developers are not expected to implement one.
