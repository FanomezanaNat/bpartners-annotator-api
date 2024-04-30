# [2.6.0](https://github.com/b-partners/bpartners-annotator-api/compare/v2.5.0...v2.6.0) (2024-04-30)


### Features

* synchronous separated annotated task saving ([09f3d7e](https://github.com/b-partners/bpartners-annotator-api/commit/09f3d7e888162fd3dd433eb7417555820c8f36f5))



# [2.5.0](https://github.com/b-partners/bpartners-annotator-api/compare/v2.4.1...v2.5.0) (2024-04-04)


### Bug Fixes

* Annotation is not nullable ([cbf37eb](https://github.com/b-partners/bpartners-annotator-api/commit/cbf37eb420d582d7ff60842b751426df95a60b9f))
* Annotation.Polygon could not be deserialized ([38d2259](https://github.com/b-partners/bpartners-annotator-api/commit/38d2259b7d866a91945d5a2ac99289365da2c474))
* correct api link ([47f8065](https://github.com/b-partners/bpartners-annotator-api/commit/47f806545ae5c7a1768c376eb6250dca79b99b98))
* correct enum array type for user_role ([c03d94e](https://github.com/b-partners/bpartners-annotator-api/commit/c03d94e08db34d4aff5c2bd672cd64431bff6754))
* do not compute jobs annotation statistics on findAll, only on getById ([a5550c7](https://github.com/b-partners/bpartners-annotator-api/commit/a5550c7bff80e95fbeb3999c8ed308ff6d5d813a))
* drop size, height, width cols from task and add height and width to job set to 1024, 1024 for null columns ([1839d1f](https://github.com/b-partners/bpartners-annotator-api/commit/1839d1f4ad02fee5dcbbabf2e4ad13c7f329c08e))
* missing creation timestamp mapping in AnnotationBatchMapper ([8d83512](https://github.com/b-partners/bpartners-annotator-api/commit/8d835126bdf034d398de5e428119212f51110df9))
* missing Transaction on JobExportInitiatedService and missing BoundingBox in CocoExportService ([c003c7f](https://github.com/b-partners/bpartners-annotator-api/commit/c003c7fba753bff91547a0acd505e400d173bb97))
* only completed job cannot fail ([61b5eb6](https://github.com/b-partners/bpartners-annotator-api/commit/61b5eb60e5d16b6af5c46e4c3c0bf4d253d536ce))
* remainingTaskForUserId considers geojobsUsers ([95b1a28](https://github.com/b-partners/bpartners-annotator-api/commit/95b1a2850003f4ac25cdd3a7fed7d3ac274a10fc))


### Features

* add width, height, size to task for internal use during export ([3a26a4e](https://github.com/b-partners/bpartners-annotator-api/commit/3a26a4e00fffa8da2542fd67c2529fa8e516eda5))
* annotators can get tasks assigned to geo-jobs annotators from their jobs ([8c9b4c7](https://github.com/b-partners/bpartners-annotator-api/commit/8c9b4c7c409640d29c0017f728cc6a93dff50720))
* annotators can read annotations made by self or by geo-jobs ([72562c3](https://github.com/b-partners/bpartners-annotator-api/commit/72562c3778fa1dcbae024f1dfed33f051bac5b70))
* asynchronous job export ([d4b0aef](https://github.com/b-partners/bpartners-annotator-api/commit/d4b0aef505c98c5cb1bd3d626e8f59eccdc4a48c))
* cc exported job to a specific configurable email ([bb8b0a0](https://github.com/b-partners/bpartners-annotator-api/commit/bb8b0a016d5e878f9a6bbc8340e5fe83b94f0729))
* compute latest annotation statistics by job ([fc39178](https://github.com/b-partners/bpartners-annotator-api/commit/fc391781392c4f9529dc62332f75b47ab5a0506d))
* export job to coco format, and separate JobExportService into multiple classes from service.jobExport package ([aa39c7b](https://github.com/b-partners/bpartners-annotator-api/commit/aa39c7b554d84c0a2e35e1f9185aec24f40ed522))
* filter jobs by name and type ([c2ac97c](https://github.com/b-partners/bpartners-annotator-api/commit/c2ac97cccedaba8bc23169b69cb4f4338c373e57))
* send email and set job to ready after tasks and annotations creation finished following c0199c0 ([a1a6c2d](https://github.com/b-partners/bpartners-annotator-api/commit/a1a6c2d770676038642ff17f85b1c05b228b108e))


### Reverts

* Revert "chore: revert if COCO model is needed" ([cf7ec0f](https://github.com/b-partners/bpartners-annotator-api/commit/cf7ec0f90c7ae75753470b7934865b7d2450c0af))



## [2.4.1](https://github.com/b-partners/bpartners-annotator-api/compare/v2.4.0...v2.4.1) (2024-02-02)


### Bug Fixes

* health endpoints are now publicly accessible ([ba11f45](https://github.com/b-partners/bpartners-annotator-api/commit/ba11f45d46190f302927516ff332e0a503b295db))
* throw bad request if task status is set to correct without setting userId ([7084261](https://github.com/b-partners/bpartners-annotator-api/commit/7084261bc242738522828f8abc9f2c6f2f340611))



# [2.4.0](https://github.com/b-partners/bpartners-annotator-api/compare/v2.1.0...v2.4.0) (2024-01-30)


### Bug Fixes

* add unique constraint to job.name and handle duplicates ([44c60b4](https://github.com/b-partners/bpartners-annotator-api/commit/44c60b452a38b91caeb5b2619e60557f8de3f47a))
* Annotation.Polygon.Point must not be null ([fe3a43f](https://github.com/b-partners/bpartners-annotator-api/commit/fe3a43f7bb821bd276c7a2a770cd2d8719803a15))
* annotations not correctly saved in batch ([b703531](https://github.com/b-partners/bpartners-annotator-api/commit/b703531d7d3414c3754bca0572748865df74bc89))
* available tasks are either your own (to_correct, under_completion) tasks or any pending task ([6527e98](https://github.com/b-partners/bpartners-annotator-api/commit/6527e9874ed323c84d69985992d81e9adc46ec50))
* correctly name variables and correct sql logic for querying annotation batch review ([9b92929](https://github.com/b-partners/bpartners-annotator-api/commit/9b929296797503196d4d172bf6b3222a82cec2b4))
* labels are not updatable on a job ([34eba69](https://github.com/b-partners/bpartners-annotator-api/commit/34eba69482898780fde4e79e37e09829d7b6ee8c))
* some annotation attributes are mandatory, label is not nullable anywhere ([7b7411c](https://github.com/b-partners/bpartners-annotator-api/commit/7b7411cbdca0886ac24d8a8a76851887d1723dd5))
* vgg task key is its filename ([e3727d7](https://github.com/b-partners/bpartners-annotator-api/commit/e3727d75c35ef0d50f170c3e957f485176f9c714))


### Features

* add creationDatetime to annotationBatch fields ([b33f9b7](https://github.com/b-partners/bpartners-annotator-api/commit/b33f9b7048350413ec092a4c2492ad4c18e4e713))
* add remainingTaskForUserId in TaskStatistics attribute ([7dff804](https://github.com/b-partners/bpartners-annotator-api/commit/7dff804b4dde1053700092cb58652893beecd192))
* synchronous export for VGG ([1884c4c](https://github.com/b-partners/bpartners-annotator-api/commit/1884c4c07f068142e954580f172fdc2552b16262))



# [2.1.0](https://github.com/b-partners/bpartners-annotator-api/compare/v2.0.0...v2.1.0) (2023-12-07)


### Bug Fixes

* only complete job if it finishes all tasks ([bc10020](https://github.com/b-partners/bpartners-annotator-api/commit/bc10020fad15cbcafa618ae07d7beeb32e9b04a0))


### Features

* filter by status and paginate jobs ([1aefefa](https://github.com/b-partners/bpartners-annotator-api/commit/1aefefa292d9c2a8cb8a7ce3b51debebc4844605))
* filter tasks by status and userId ([608ef02](https://github.com/b-partners/bpartners-annotator-api/commit/608ef021ad5dffb6e1d85410f874bc58f53efc53))
* whenever reviewed, the annotation's task's job status will become TO_CORRECT ([e1f2aa8](https://github.com/b-partners/bpartners-annotator-api/commit/e1f2aa8b5bbbd3677bc4e612ce24c22616c73d23))



# [2.0.0](https://github.com/b-partners/bpartners-annotator-api/compare/v1.0.0...v2.0.0) (2023-12-01)


### Bug Fixes

* wrong value for isTaskAnnotable variable ([844d66b](https://github.com/b-partners/bpartners-annotator-api/commit/844d66bb21b82c0e1e24ab7053acc5a66ab21181))


* feat!: annotation_batch_review reviews a batch ([3a7d16d](https://github.com/b-partners/bpartners-annotator-api/commit/3a7d16d5d90e190be98bf844baa283b5753f6824))


### BREAKING CHANGES

* annotation_reviews are grouped in a batch_review



# [1.0.0](https://github.com/b-partners/bpartners-annotator-api/compare/v0.10.1...v1.0.0) (2023-12-01)


### Bug Fixes

* ADMIN can't annotate tasks or get random Task, it is reserved to annotators ([842d4c0](https://github.com/b-partners/bpartners-annotator-api/commit/842d4c07c4ef700c02207cb037faeb2e27312c60))
* SelfMatcher DOES NOT handle ADMIN access ([e812d99](https://github.com/b-partners/bpartners-annotator-api/commit/e812d994a77f1d958372b2f4e95e36eea0675e5d))


* feat!: group annotations by batch ([61cc339](https://github.com/b-partners/bpartners-annotator-api/commit/61cc339f35f6a9807ebc65012ff259047f2763c0))


### Features

* admin annotation batch review ([602a1d3](https://github.com/b-partners/bpartners-annotator-api/commit/602a1d39be412df24c1b0416ebb840d0c7505a28))
* get annotations and annotation ([1ffd591](https://github.com/b-partners/bpartners-annotator-api/commit/1ffd5917613e4c33ecd05b62a369e32ecece021c))
* let user see annotation batches ([4101bde](https://github.com/b-partners/bpartners-annotator-api/commit/4101bded5dcd68bbaa49a4ad47addba9309b8334))
* upgrade poja to v4.0.0 ([1ed1c63](https://github.com/b-partners/bpartners-annotator-api/commit/1ed1c635aab19c9a8ea0bb0ac9afb5b8de2b94b2))
* user get annotation batch reviews and annotation batch review ([af9bb62](https://github.com/b-partners/bpartners-annotator-api/commit/af9bb62058bc09890be850e7050d1e954dfc8279))


### BREAKING CHANGES

* annotations are now grouped in a batch



## [0.10.1](https://github.com/b-partners/bpartners-annotator-api/compare/v0.10.0...v0.10.1) (2023-11-29)


### Bug Fixes

* JobCreated ignores some properties inferred from getter ([833a109](https://github.com/b-partners/bpartners-annotator-api/commit/833a109645f01f1396e3430ac6edbc7715cc7842))



# [0.10.0](https://github.com/b-partners/bpartners-annotator-api/compare/v0.9.0...v0.10.0) (2023-11-28)


### Features

* implement update user team endpoint ([605550f](https://github.com/b-partners/bpartners-annotator-api/commit/605550fabf3baef0d46ea5cec7e65e4d1cec69b0))



# [0.9.0](https://github.com/b-partners/bpartners-annotator-api/compare/v0.8.1...v0.9.0) (2023-11-23)


### Bug Fixes

* map imageUri correctly ([dc3e324](https://github.com/b-partners/bpartners-annotator-api/commit/dc3e3245cf2d210cb788a6b1b9a60b4d6df66c83))


### Features

* job has TaskStatistics ([eddc2a9](https://github.com/b-partners/bpartners-annotator-api/commit/eddc2a90c92665b89456039f4a0a36ed7ed5df8e))



